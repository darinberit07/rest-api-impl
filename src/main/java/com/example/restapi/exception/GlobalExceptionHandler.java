package com.example.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
