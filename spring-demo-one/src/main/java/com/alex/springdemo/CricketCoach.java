package com.alex.springdemo;

public class CricketCoach implements Coach {

    private String email;
    private String team;

    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("Inside no-arg constructor");
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("Inside email setter");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("Inside team setter");
        this.team = team;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setter method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
