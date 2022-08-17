package com.alex.reactivedemo;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class AppMono {
    public static void main(String[] args) {
        Mono.firstWithValue(
                        Mono.delay(Duration.ofMillis(100)).log().thenReturn("bar").log(),
                        Mono.just(1).log().map(integer -> {
                            try {
                                Thread.sleep(96);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return "foo " + integer;
                        }).log()
                )
                .subscribe((s) -> {
                    System.out.println(Thread.currentThread().getName() + " =>>>>>> " + s);
                });
    }
}
