package com.example.restapi.exception;

import org.springframework.http.HttpStatus;

public class ExceptionDetails {
	private String message;
	private HttpStatus httpStatus;
	
	public ExceptionDetails(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	
}
