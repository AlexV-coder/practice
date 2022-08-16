package com.alex.openfeignexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignexampleApplication.class, args);
	}

}
