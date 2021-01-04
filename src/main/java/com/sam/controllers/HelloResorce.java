package com.sam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResorce {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
