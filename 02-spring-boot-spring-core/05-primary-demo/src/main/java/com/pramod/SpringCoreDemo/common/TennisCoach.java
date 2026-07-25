package com.pramod.SpringCoreDemo.common;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String dailyWorkout(){
        return "Play 10 Fast Tennis Balls";
    }
}
