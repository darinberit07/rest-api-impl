package com.example.restapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restapi.model.LoginCredentialsModel;
import com.example.restapi.repository.LoginCredentialsRepository;
import com.example.restapi.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	
	Logger logger = LoggerFactory.getLogger(RegisterUserServiceImpl.class);
	
	@Autowired
	private LoginCredentialsRepository repository;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	@Override
	public String registerUser(LoginCredentialsModel credentials) {
		logger.info(credentials.getUsername());
		logger.info(credentials.getPassword());
		credentials.setPassword(encoder.encode(credentials.getPassword()));
		repository.save(credentials);
		return "New user registered";
	}

}
