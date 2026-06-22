package com.developersboard.game_engine.common;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 2000 meters every day";
    }

}