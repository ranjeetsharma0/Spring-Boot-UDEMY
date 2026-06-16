package com.developersboard.game_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class GameEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameEngineApplication.class, args);
    }

    // 🔓 This tells Spring Security to bypass the login page for "/"
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll() // Let anyone access the home endpoint
                .anyRequest().authenticated()     // Keep everything else locked down
            )
            .formLogin(form -> form.permitAll()); // Keep default form configuration ready
        return http.build();
    }
}