package com.example.restapi.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class EmployeePrincipal implements UserDetails {
	
	LoginCredentialsModel credentials;
	
	public EmployeePrincipal(LoginCredentialsModel credentials) {
		this.credentials = credentials;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return credentials.getPassword();
	}

	@Override
	public String getUsername() {
		return credentials.getUsername();
	}
}
