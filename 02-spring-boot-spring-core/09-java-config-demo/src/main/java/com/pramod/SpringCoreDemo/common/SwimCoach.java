package com.pramod.SpringCoreDemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor :" +getClass().getSimpleName());
    }


    public String dailyWorkout(){
        return "Swim 1km As WarmUp!!";
    }
}
