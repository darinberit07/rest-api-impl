package com.example.restapi.exception;

@SuppressWarnings("serial")
public class EmployeeDetailsConflictException extends RuntimeException {
	public EmployeeDetailsConflictException(String message) {
		super(message);
	}
	
}
