package com.mateus.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MyFirstClass MyFirstClass(){
        return new MyFirstClass();
    }
}
