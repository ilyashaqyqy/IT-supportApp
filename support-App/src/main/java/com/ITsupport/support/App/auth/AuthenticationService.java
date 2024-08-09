package com.ITsupport.support.App.auth;




import com.ITsupport.support.App.config.JwtService;
import com.ITsupport.support.App.model.Role;
import com.ITsupport.support.App.model.Utilisateur;
import com.ITsupport.support.App.repository.AdminRepository;
import com.ITsupport.support.App.repository.TechnicienRepository;
import com.ITsupport.support.App.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository utilisateurRepository;
    private final AdminRepository adminRepository;
    private final TechnicienRepository technicienRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Utilisateur newUser = new Utilisateur();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setEmail(request.getEmail());
        newUser.setRole(Role.ROLE_USER);

        Utilisateur savedUser = utilisateurRepository.save(newUser);

        String jwtToken = jwtService.generateToken(savedUser);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails user = loadUserByUsername(request.getUsername());
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private UserDetails loadUserByUsername(String username) {
        UserDetails user = utilisateurRepository.findByUsername(username)
                .orElse(null);
        if (user == null) {
            user = adminRepository.findByUsername(username)
                    .orElse(null);
        }
        if (user == null) {
            user = technicienRepository.findByUsername(username)
                    .orElse(null);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

