package com.example.springrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
}
