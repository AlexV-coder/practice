package com.alex.reactivedemo.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FluxAndMonoServices {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana")).log();
    }

    public Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitsFluxFilter(int number) {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .log()
                .filter(s -> s.length() > number)
                .log();
    }

    public Flux<String> fruitsFluxFilterMap(int number) {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .filter(s -> s.length() > number)
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitsFluxFlatMap() {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .flatMap(s -> Flux.just(s.split("")))
                .log();
    }

    public Flux<String> fruitsFluxFlatMapAsync() {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana")).log()
                .flatMap(s -> Flux.just(s.split(""))).log()
                .delayElements(Duration.ofMillis(new Random().nextInt(1000))).log();
    }

    public Flux<String> fruitsFluxConcatMapAsync() {
        return Flux.fromIterable(List.of("Orange", "Apple", "Banana")).log()
                .concatMap(s -> Flux.just(s.split(""))).log()
                .delayElements(Duration.ofMillis(new Random().nextInt(1000))).log();
    }

    public Flux<String> fruitsFluxMerge() {
        Flux<String> fruits = Flux.just("Mango", "Orange")
                .delayElements(Duration.ofMillis(50));
        Flux<String> veggies = Flux.just("Potato", "Onion")
                .delayElements(Duration.ofMillis(75));

        return Flux.merge(fruits, veggies).log();
    }

    public Mono<String> fruitMono() {
        return Mono.just("Mango");
    }

    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

        //fluxAndMonoServices.fruitsFluxFilter(5).subscribe(System.out::println);
        //fluxAndMonoServices.fruitsFluxFlatMap().subscribe(System.out::println);
    }
}
