package com.alex.springcloudfunctions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringcloudfunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudfunctionsApplication.class, args);
	}

	@Bean
	public Function<String, String> toUpperCase() {
		return s -> new StringBuilder(s).toString().toUpperCase();
	}

	@Bean
	public Supplier<String> getMessage() {
		return () -> "Welcome to Daily Code Buffer!";
	}

	@Bean
	public Consumer<String> writeMessage() {
		return s -> System.out.println(s);
	}
}
