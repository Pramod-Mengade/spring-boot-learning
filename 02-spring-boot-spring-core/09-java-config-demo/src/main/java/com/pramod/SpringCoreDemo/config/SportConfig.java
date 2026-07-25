package com.pramod.SpringCoreDemo.config;

import com.pramod.SpringCoreDemo.common.Coach;
import com.pramod.SpringCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
