package com.mateus.springproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello(){
        return "Hello from first controller";
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String post(@RequestBody String message){
        return "Request accepted in post: " + message;
    }

    @PostMapping("/post-order")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String post(@RequestBody Order order){
        String response = "Request accepted in post-order: " + order.getProductName() + order.getCustomerName() + order.getQuantity();
        return response;
    }


}
