package com.example.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.LoginCredentialsModel;
import com.example.restapi.service.RegisterUserService;

@RestController
public class RegisterUserController {
	
	@Autowired
	private RegisterUserService service;
	
	@PostMapping("/register")
	public String registerUserCredentials(@RequestBody LoginCredentialsModel cred) {
		return service.registerUser(cred);	
	}
}
