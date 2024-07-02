package com.example.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = EmployeeDetailsNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeDetailsNotFoundException(EmployeeDetailsNotFoundException exe){
		ExceptionDetails e = new ExceptionDetails(exe.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmployeeDatabaseEmptyException.class)
	public ResponseEntity<Object> handleEmployeeDatabaseEmptyException(EmployeeDatabaseEmptyException exe){
		ExceptionDetails e = new ExceptionDetails(exe.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmployeeDetailsConflictException.class)
	public ResponseEntity<Object> handleEmployeeDetailsConflictException(EmployeeDetailsConflictException exe){
		ExceptionDetails e = new ExceptionDetails(exe.getMessage(), HttpStatus.CONFLICT);
		return new ResponseEntity<Object>(e, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exe){
		ExceptionDetails e = new ExceptionDetails(exe.getMessage()+" for this URI Endpoint", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
	}
}
