package com.cst438.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                //.antMatchers("/").permitAll()  // Permit all access to the root URL
                                .anyRequest().authenticated()  // Require authentication for any other request
                )
                .oauth2Login(Customizer.withDefaults());  // Configure OAuth2 login

        return http.build();
    }
}


