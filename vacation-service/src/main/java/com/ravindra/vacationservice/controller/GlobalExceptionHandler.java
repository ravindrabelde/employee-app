package com.ravindra.vacationservice.controller;

import com.ravindra.vacationservice.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGeneralException(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<>("An error occurred while processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
