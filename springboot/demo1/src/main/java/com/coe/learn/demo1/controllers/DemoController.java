package com.coe.learn.demo1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Value("${coe.learn.usename}")
    String username;

    @GetMapping("/user")
    public String user() {
        return "Welcome " + username;
    }

}