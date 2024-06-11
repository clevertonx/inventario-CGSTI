package com.cgsti.cgsti.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class Configurations {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {

                    req.requestMatchers(HttpMethod.GET, "/reservas/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "/reservaHistorico/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "/reservaHistorico/paginados").permitAll();
                    req.requestMatchers(HttpMethod.PUT, "/reservaHistorico/**").permitAll();
                    req.requestMatchers(HttpMethod.DELETE, "/reservaHistorico/**").permitAll();
                    req.requestMatchers(HttpMethod.POST, "/reservas/**").permitAll();
                    req.requestMatchers(HttpMethod.PUT, "/reservas/**").permitAll();
                    req.requestMatchers(HttpMethod.DELETE, "/reservas/**").permitAll();
                    req.requestMatchers(HttpMethod.POST, "/equipamentos/**").permitAll();
                    req.requestMatchers(HttpMethod.PUT, "/equipamentos/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "/equipamentos/**").permitAll();
                    req.requestMatchers(HttpMethod.DELETE, "/equipamentos/**").permitAll();
                    req.requestMatchers(HttpMethod.PUT, "/reservas/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/v3/api-docs/**").permitAll();
                    req.requestMatchers(HttpMethod.POST, "/usuario/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "http://localhost:3000").permitAll();
                    req.requestMatchers(HttpMethod.GET, "http://127.0.0.1:5502/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "http://127.0.0.1:8080/**").permitAll();
                    req.requestMatchers(HttpMethod.POST, "http://127.0.0.1:5502/**").permitAll();
                    req.requestMatchers(HttpMethod.POST, "http://10.8.4.71:8080/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "http://10.8.4.71:8080/**").permitAll();
                    req.requestMatchers(HttpMethod.PUT, "http://10.8.4.71:8080/**").permitAll();
                    req.requestMatchers(HttpMethod.DELETE, "http://10.8.4.71:8080/**").permitAll();
                    req.requestMatchers(HttpMethod.POST, "http://10.8.4.71:5500/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "http://10.8.4.71:5500/**").permitAll();
                    req.requestMatchers(HttpMethod.PUT, "http://10.8.4.71:5500/**").permitAll();
                    req.requestMatchers(HttpMethod.DELETE, "http://10.8.4.71:5500/**").permitAll();
                    req.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    req.anyRequest().authenticated();
                })
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}