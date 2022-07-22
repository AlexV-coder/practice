package com.alex.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("Inside default constructor");
    }

    @PostConstruct
    public void doStartupStuff() {
        System.out.println("Doing startup stuff..");
    }

    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("Doing cleanup stuff..");
    }

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


    public FortuneService getFortuneService() {
        return fortuneService;
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("Inside setter method");
//        this.fortuneService = fortuneService;
//    }

//    @Autowired
//    public void regularMethod(FortuneService fortuneService) {
//        System.out.println("Inside regular method");
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
