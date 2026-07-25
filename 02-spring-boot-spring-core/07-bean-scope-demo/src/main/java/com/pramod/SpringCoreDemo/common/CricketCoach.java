package com.pramod.SpringCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor :" +getClass().getName() );
    }
    @Override
    public String dailyWorkout(){
        return "Practice Fast Bawling for 15 minutes!!";
    }
}
