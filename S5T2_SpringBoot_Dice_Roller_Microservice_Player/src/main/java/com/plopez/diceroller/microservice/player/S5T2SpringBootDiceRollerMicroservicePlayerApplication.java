package com.plopez.diceroller.microservice.player;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S5T2SpringBootDiceRollerMicroservicePlayerApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(S5T2SpringBootDiceRollerMicroservicePlayerApplication.class, args);
	}

}
