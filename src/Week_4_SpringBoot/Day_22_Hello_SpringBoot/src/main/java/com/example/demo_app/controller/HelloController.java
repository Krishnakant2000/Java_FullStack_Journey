package com.example.demo_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. Tell Spring: "This class handles Web Requests"
@RestController
public class HelloController {

    // 2. Tell Spring: "When user visits /hello, run this method"
    @GetMapping("/hello")
    public String sayHello(){
        return "Welcome to Spring Boot in late 2025! The console is dead.";
    }

    // 3. Another endpoint
    @GetMapping("/status")
    public String checkStatus(){
        return "System is Online. All systems go.";
    }

}
