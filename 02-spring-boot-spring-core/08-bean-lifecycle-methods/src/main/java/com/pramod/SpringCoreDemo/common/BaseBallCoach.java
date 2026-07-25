package com.pramod.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseBallCoach implements Coach{
    public BaseBallCoach(){
        System.out.println("In Constructor :" +getClass().getName() );
    }
    @Override
    public  String dailyWorkout(){
        return "Play 10 Fast baseBalls!";
    }
}
