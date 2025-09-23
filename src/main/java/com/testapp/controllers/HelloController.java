package com.testapp.controllers;

import com.monframework.web.annotation.*;

// import com.monframework.web.annotation.GetMapping;
// import com.monframework.web.annotation.RestController;

@RestController
public class HelloController { 
    @GetMapping("/hello")

    public String hello() {
        return "Hello from testapp!";
    }
}