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
        return "Request accepted in post-order: " + order.getProductName() + order.getCustomerName() + order.getQuantity();
    }


    // http://localhost:8080/hello/{username}
    @GetMapping("/hello/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String pathVar(@PathVariable("username") String username){
        return "Request accepted in post-order: " + username;
    }

    // http://localhost:8080/hello?param1=value1&param2=value2
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String RequestParam(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName){
        return "Request accepted in post-order: " + firstName + " " + lastName;
    }




}
