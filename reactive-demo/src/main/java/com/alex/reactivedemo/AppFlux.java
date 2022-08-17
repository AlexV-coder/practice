package com.alex.reactivedemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class AppFlux
{
    public static void main( String[] args ) throws InterruptedException {

        Flux<Long> firstFlux = Flux.interval(Duration.ofMillis(100)).log();
        firstFlux.subscribe(s -> {
            System.out.println(Thread.currentThread().getName() + " =>>>>> First Flux: " + s);
        });

        Flux<Long> secondFlux = firstFlux.take(10);
        secondFlux.subscribe((s) -> {
            System.out.println(Thread.currentThread().getName() + " =>>>>> Second Flux: " + s);
        });

        Mono<Boolean> biggerThanFive = secondFlux.any(nr -> nr > 5);
        biggerThanFive.subscribe((s) -> {
            System.out.println(Thread.currentThread().getName() + " =>>>>> BiggerThanFive First Sub Flux: " + s);
        });
        biggerThanFive.subscribe((s) -> {
            System.out.println(Thread.currentThread().getName() + " =>>>>> BiggerThanFive Second Sub Flux: " + s);
        });

        for(int i = 1; i <= 500; i++) {
            Thread.sleep(10);
            System.out.println("=>>>>> Here");
        }
        Thread.sleep(1000);
    }
}
