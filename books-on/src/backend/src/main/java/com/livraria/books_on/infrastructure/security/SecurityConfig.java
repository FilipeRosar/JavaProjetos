package com.livraria.books_on.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter _jwtFilter;
    
    @Autowired
    private CorsConfigurationSource corsConfigurationSource;

    public SecurityConfig(JwtFilter _jwtFilter) {
        this._jwtFilter = _jwtFilter;
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/auth/**").permitAll()
                        .requestMatchers("/v1/book/**").permitAll()
                        .requestMatchers("/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/auth/**",
                                "/v1/user/**",
                                "/v1/sales/**",
                                "/v1/author/**",
                                "/v1/publisher/**",
                                "/v1/reports/**",
                                "/book/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(_jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
