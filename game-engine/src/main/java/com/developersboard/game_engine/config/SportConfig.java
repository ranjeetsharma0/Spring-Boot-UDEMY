package com.developersboard.game_engine.config;

import com.developersboard.game_engine.common.Coach;
import com.developersboard.game_engine.common.SwimCoach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
