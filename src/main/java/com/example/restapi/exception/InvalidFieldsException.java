package com.example.restapi.exception;

@SuppressWarnings("serial")
public class InvalidFieldsException extends RuntimeException {
	public InvalidFieldsException(String message) {
		super(message);
	}
	
}
