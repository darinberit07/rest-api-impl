package com.example.restapi.exception;

@SuppressWarnings("serial")
public class EmployeeDatabaseEmptyException extends RuntimeException {
	public EmployeeDatabaseEmptyException(String message) {
		super(message);
	}
	
}
