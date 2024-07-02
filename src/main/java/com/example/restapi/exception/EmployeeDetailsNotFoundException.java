package com.example.restapi.exception;

@SuppressWarnings("serial")
public class EmployeeDetailsNotFoundException extends RuntimeException {

	public EmployeeDetailsNotFoundException(String message) {
		super(message);
	}
	
}
