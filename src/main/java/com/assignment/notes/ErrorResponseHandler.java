package com.assignment.notes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorResponseHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> generalException(IllegalArgumentException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Format" + e.getMessage());
	}

}
