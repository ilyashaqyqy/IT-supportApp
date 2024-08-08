package com.ITsupport.support.App.config;


import com.ITsupport.support.App.repository.AdminRepository;
import com.ITsupport.support.App.repository.TechnicienRepository;
import com.ITsupport.support.App.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UtilisateurRepository utilisateurRepository ;
    private final AdminRepository adminRepository;
    private final TechnicienRepository technicienRepository;


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
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
                throw new UsernameNotFoundException("Username not found");
            }
            return user;
        };
    }


    @Bean
    public AuthenticationProvider authenticationProvider (){

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws  Exception{
        return config.getAuthenticationManager();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

}