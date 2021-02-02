package com.javainuse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javainuse.components.SpringBootHelloWorldService;

@Controller
public class SpringBootHelloWorldController {
	
	private final SpringBootHelloWorldService springBootHelloWorldService;

    @Autowired
    public SpringBootHelloWorldController(SpringBootHelloWorldService springBootHelloWorldService) {
        this.springBootHelloWorldService = springBootHelloWorldService;
    }

    @GetMapping("/helloWorld")
    public ResponseEntity sayHello() {
        return ResponseEntity.ok(springBootHelloWorldService.helloWorld());
    }

}
