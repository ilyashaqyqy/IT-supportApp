package com.ITsupport.support.App.auth;




import com.ITsupport.support.App.config.JwtService;
import com.ITsupport.support.App.model.Admin;
import com.ITsupport.support.App.model.Role;
import com.ITsupport.support.App.model.Technicien;
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

import java.util.Optional;

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
        Role userRole = Role.ROLE_USER; // Default to ROLE_USER

        if (request.getRole() != null) {
            try {
                userRole = Role.valueOf(String.valueOf(request.getRole()));
            } catch (IllegalArgumentException e) {
                // Invalid role provided, keep the default ROLE_USER
            }
        }

        String jwtToken;

        switch (userRole) {
            case ROLE_ADMIN:
                Admin newAdmin = new Admin();
                newAdmin.setUsername(request.getUsername());
                newAdmin.setPassword(passwordEncoder.encode(request.getPassword()));
                newAdmin.setEmail(request.getEmail());
                newAdmin.setRole(Role.ROLE_ADMIN);
                Admin savedAdmin = adminRepository.save(newAdmin);
                jwtToken = jwtService.generateToken(savedAdmin);
                break;

            case ROLE_TECHNICIEN:
                Technicien newTechnicien = new Technicien();
                newTechnicien.setUsername(request.getUsername());
                newTechnicien.setPassword(passwordEncoder.encode(request.getPassword()));
                newTechnicien.setEmail(request.getEmail());
                newTechnicien.setRole(Role.ROLE_TECHNICIEN);
                Technicien savedTechnicien = technicienRepository.save(newTechnicien);
                jwtToken = jwtService.generateToken(savedTechnicien);
                break;

            case ROLE_USER:
            default:
                Utilisateur newUser = new Utilisateur();
                newUser.setUsername(request.getUsername());
                newUser.setPassword(passwordEncoder.encode(request.getPassword()));
                newUser.setEmail(request.getEmail());
                newUser.setRole(Role.ROLE_USER);
                Utilisateur savedUser = utilisateurRepository.save(newUser);
                jwtToken = jwtService.generateToken(savedUser);
                break;
        }

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Object user = loadUserByUsername(request.getUsername());
        String jwtToken = jwtService.generateToken((UserDetails) user);

        Long userId = null;

        if (user instanceof Utilisateur) {
            userId = ((Utilisateur) user).getId();
        } else if (user instanceof Admin) {
            userId = ((Admin) user).getId();
        } else if (user instanceof Technicien) {
            userId = ((Technicien) user).getId();
        }

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(userId)
                .build();
    }


    private Object loadUserByUsername(String username) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur.isPresent()) {
            return utilisateur.get();
        }

        Optional<Admin> admin = adminRepository.findByUsername(username);
        if (admin.isPresent()) {
            return admin.get();
        }

        Optional<Technicien> technicien = technicienRepository.findByUsername(username);
        if (technicien.isPresent()) {
            return technicien.get();
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}