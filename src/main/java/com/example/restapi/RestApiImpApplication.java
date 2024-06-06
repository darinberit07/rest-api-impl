package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.restapi.repository")
public class RestApiImpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiImpApplication.class, args);
	}

}
