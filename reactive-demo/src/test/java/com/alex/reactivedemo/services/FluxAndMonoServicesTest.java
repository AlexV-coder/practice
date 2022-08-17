package com.alex.reactivedemo.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitsFlux() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux).expectNext("Orange", "Apple", "Banana").verifyComplete();
    }

    @Test
    void fruitMono() {
        Mono<String> fruitsMono = fluxAndMonoServices.fruitMono();
        StepVerifier.create(fruitsMono).expectNext("Mango").verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitsFlux).expectNext("ORANGE", "APPLE", "BANANA").verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFilter(5);
        StepVerifier.create(fruitsFlux).expectNext("Orange", "Banana").verifyComplete();
    }

    @Test
    void fruitsFluxFilterMap() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFilterMap(5);
        StepVerifier.create(fruitsFlux).expectNext("ORANGE", "BANANA").verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFlatMap();
        StepVerifier.create(fruitsFlux).expectNext("O", "r", "a", "n", "g", "e", "A", "p", "p", "l", "e", "B", "a", "n", "a", "n", "a").verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFlatMapAsync();
        StepVerifier.create(fruitsFlux).expectNextCount(17).verifyComplete();
    }

    @Test
    void fruitsFluxConcatMapAsync() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxConcatMapAsync();
        StepVerifier.create(fruitsFlux).expectNextCount(17).verifyComplete();
    }

    @Test
    void fruitsFluxMerge() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxMerge();
        StepVerifier.create(fruitsFlux).expectNext("Mango", "Potato", "Orange", "Onion").verifyComplete();
    }
}