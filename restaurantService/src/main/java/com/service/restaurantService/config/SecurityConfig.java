package com.service.restaurantService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity
public class SecurityConfig {
    @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable()) // Desactiva CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // Permite todos los endpoints
        );
  //      http.csrf(csrf->csrf.disable())
 //               .authorizeHttpRequests(auth->auth.requestMatchers("/v3/api-docs/**","/swagger-ui/**","/actuator/**").permitAll().anyRequest().authenticated());
//                .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults())
//                .opaqueToken(Customizer.withDefaults()));
        return http.build();
    }
}
