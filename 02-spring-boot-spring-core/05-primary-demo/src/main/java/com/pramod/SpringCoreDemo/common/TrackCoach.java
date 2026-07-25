package com.pramod.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach{
    @Override
    public String dailyWorkout(){
        return "Run fast for 10 minutes";
    }
}
