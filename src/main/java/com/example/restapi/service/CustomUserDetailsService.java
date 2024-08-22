package com.example.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restapi.model.EmployeePrincipal;
import com.example.restapi.model.LoginCredentialsModel;
import com.example.restapi.repository.LoginCredentialsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private LoginCredentialsRepository loginCredentialsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginCredentialsModel credentials = loginCredentialsRepository.findByUsername(username);
		if(credentials == null) {
			throw new UsernameNotFoundException("The user does not exist");
		}
		
		return new EmployeePrincipal(credentials);
		
		
	}

}
