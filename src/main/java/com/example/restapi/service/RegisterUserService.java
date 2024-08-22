package com.example.restapi.service;

import com.example.restapi.model.LoginCredentialsModel;

public interface RegisterUserService {
	String registerUser(LoginCredentialsModel credentials);
}
