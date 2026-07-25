package com.pramod.SpringCoreDemo.common;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In Constructor :" +getClass().getName() );
    }
    @Override
    public String dailyWorkout(){
        return "Play 10 Fast Tennis Balls";
    }
}
