package com.plopez.diceroller.microservice.authservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Auth microservice", description = "Process the information related to " +
		"authenticated and secure access for teh Dice Roller Player/Game microservices; It is able to register user for access microservices, " +
		"generate and validate user microservices access tokens.", version = "1.0.0"))
public class S5T2SpringBootDiceRollerMicroserviceAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(S5T2SpringBootDiceRollerMicroserviceAuthServiceApplication.class, args);
	}

}
