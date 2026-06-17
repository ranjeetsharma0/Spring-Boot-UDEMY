package com.developersboard.game_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@SpringBootApplication(scanBasePackages = {
    "com.developersboard.game_engine",
    "com.developersboard.util" // 👈 This forces Spring to look inside your sibling folder!
})
public class GameEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameEngineApplication.class, args);
    }

    // 🔓 Updated security chain to bypass the login page for all three endpoints
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Added your new endpoints here so they are completely public
            .requestMatchers("/", "/workout", "/fortune", "/actuator", "/actuator/**").permitAll()                .anyRequest().authenticated()     // Keep any other future endpoints locked down
            )
            // Disabled the login form redirect to prevent the Jenkins port-clash error
            .formLogin(form -> form.disable()) 
            .csrf(csrf -> csrf.disable());     // Disabled CSRF to ensure smooth local testing
            
        return http.build();
    }
}*/
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll() // 👈 Temporarily open everything for smooth testing
        );
        
    return http.build();
    }
}