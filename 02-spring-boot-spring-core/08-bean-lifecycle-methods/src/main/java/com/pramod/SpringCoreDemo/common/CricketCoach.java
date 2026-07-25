package com.pramod.SpringCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.context.annotation.Scope;
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
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In myStartupStuff :" + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupstuff :" + getClass().getSimpleName());
    }
}
