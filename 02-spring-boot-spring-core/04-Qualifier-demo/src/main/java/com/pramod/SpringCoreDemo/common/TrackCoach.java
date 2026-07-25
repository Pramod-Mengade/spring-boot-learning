package com.pramod.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String dailyWorkout(){
        return "Run fast for 10 minutes";
    }
}
