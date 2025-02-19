package com.plopez.diceroller.microservice.game;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Game microservice", description = "Process the information related to " +
		"the Dice roller Game; It is able to connect to Player microservice player to link games with a specific player, " +
		"keep updated player success rate information, and delete all the games of a specific player.", version = "1.0.0"))
public class S5T2SpringBootDiceRollerMicroserviceGameApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(S5T2SpringBootDiceRollerMicroserviceGameApplication.class, args);
	}

}
