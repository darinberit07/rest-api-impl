package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.LoginCredentialsModel;

@Repository
public interface LoginCredentialsRepository extends JpaRepository<LoginCredentialsModel, Long>{
	LoginCredentialsModel findByUsername(String username);
}
