package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    UserDetailsManager userDetailsManager (DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define the query to retrieve the user by userName
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id ,pw ,active from members where user_id=?"
        );

        //define a querey to retrieve the authorities/role by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET , "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET , "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST , "/api/employees").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT , "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH , "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE , "/api/employees/**").hasRole("ADMIN"));

        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());
        //disable cross site request forgery (CSRF)
        //in general not required for state less api that uses post put delete and/or patch
        http.csrf(csrf ->csrf.disable());

        return http.build();
    }


/*
@Bean
public InMemoryUserDetailsManager userDetailsManager(){
    UserDetails pramod = User.builder()
            .username("pramod")
            .password("{noop}test123")
            .roles("MANAGER")
            .build();

    UserDetails sanskar = User.builder()
            .username("sanskar")
            .password("{noop}test121")
            .roles("EMPLOYEE")
            .build();

    UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}admin123")
            .roles("ADMIN")
            .build();



    return new InMemoryUserDetailsManager(pramod,sanskar,admin);*/
}
