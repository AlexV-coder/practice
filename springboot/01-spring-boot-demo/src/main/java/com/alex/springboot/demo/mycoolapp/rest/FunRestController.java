package com.alex.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // expose "/" endpoint that returns "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on the server is: " + LocalDateTime.now();
    }
}
