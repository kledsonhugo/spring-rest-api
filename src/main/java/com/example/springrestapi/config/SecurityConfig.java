package com.example.springrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desabilita CSRF para simplificar testes
            .authorizeHttpRequests()
                .requestMatchers("/api/**").authenticated() // Requer autenticação para endpoints da API
                .anyRequest().permitAll() // Permite outras requisições
            .and()
            .httpBasic(); // Usa autenticação básica para simplificar

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(
            org.springframework.security.core.userdetails.User
                .withUsername("admin")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build()
        );
    }
}
