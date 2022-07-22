package com.alex.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFurtuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "";
    }
}
