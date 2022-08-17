package com.alex.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // inject properties

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/" endpoint that returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on the server is: " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team name: " + teamName;
    }
}