package com.mateus.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class MyFirstClass {
    public String sayHello(){
        return "hello";
    }
    public String sayBye(){
        return "Bye";
    }
}
