package com.example.progectSensors;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class ProgectSensorsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProgectSensorsApplication.class, args);


	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public Logger logger(){
		return Logger.getGlobal();
	}



}
