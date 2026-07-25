package com.pramod.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor :" +getClass().getName() );
    }
    @Override
    public String dailyWorkout(){
        return "Practice Fast Bawling for 15 minutes!!";
    }
}
