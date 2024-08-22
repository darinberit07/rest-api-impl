package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.LoginCredentialsModel;

public interface LoginCredentialsRepository extends JpaRepository<LoginCredentialsModel, Long>{
	LoginCredentialsModel findByUsername(String username);
}
