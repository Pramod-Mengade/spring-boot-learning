package com.pramod.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String dailyWorkout(){
        return "Practice Fast Bawling for 15 minutes";
    }
}
