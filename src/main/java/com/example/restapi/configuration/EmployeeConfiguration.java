package com.example.restapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@PropertySource("classpath:application.yml")
public class EmployeeConfiguration{
	
	@Bean
	OpenAPI customOpenApi(@Value("${spring.application.version}")String appVersion,
			@Value("${spring.application.description}") String appDescription) {
		
		return new OpenAPI()
				.info(new Info()
						.title("REST API")
						.version(appVersion)
						.description(appDescription)
						.termsOfService("https://swagger.io/terms")
						.license(new License().name("Apache License 2.0").url("https://swagger.io"))
						); 
	}
	
}