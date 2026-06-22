package com.developersboard.game_engine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developersboard.game_engine.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
public class DemoController {
//define a private field for dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
    //public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }
        

  /*  @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;

    }
 */
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    
}