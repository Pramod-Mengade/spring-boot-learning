package com.pramod.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In Constructor :" +getClass().getName() );
    }
    @Override
    public String dailyWorkout(){
        return "Run fast for 10 minutes";
    }
}
