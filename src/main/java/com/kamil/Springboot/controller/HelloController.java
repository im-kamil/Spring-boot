package com.kamil.Springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping(value="/", method = RequestMethod.GET)
    @Value("${welcome.message}")
    private String welcomeMessage;
    @GetMapping("/")
    public String helloWorld(){
//        return "Welcome Kamil!!";
        return welcomeMessage;
    }
}
