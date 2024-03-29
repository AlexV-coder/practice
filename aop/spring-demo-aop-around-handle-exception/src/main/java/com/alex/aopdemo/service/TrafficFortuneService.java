package com.alex.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {

        if(tripWire) {
            throw new RuntimeException("Major accident! Highway is closed!");
        } else {
            return getFortune();
        }
    }
}
