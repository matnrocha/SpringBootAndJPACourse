package com.mateus.springproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:anotherSource.properties")
public class AppService {
    @Value("${my.prop}")
    private String myVar;

    public String getMyVar() {
        return myVar;
    }

}
