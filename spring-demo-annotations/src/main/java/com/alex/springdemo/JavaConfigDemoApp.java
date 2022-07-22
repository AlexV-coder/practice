package com.alex.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        Coach myCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());

        System.out.println(myCoach.getDailyFortune());

        context.close();
    }
}
