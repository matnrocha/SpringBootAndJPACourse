package com.mateus.springproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello(){
        return "Hello from first controller";
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String post(String message){
        return "Request accepted in post!";
    }


}
