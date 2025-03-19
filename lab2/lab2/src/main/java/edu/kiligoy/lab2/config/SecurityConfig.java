//package edu.kiligoy.lab2.config;
//
///*
//@author   Dtest
//@project   lab2
//@class  SecurityConfig
//@version  1.0.0
//@since 19.03.2025 - 16.06
//*/
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Дозволити всі запити без авторизації
//
//        return http.build();
//    }
//}
