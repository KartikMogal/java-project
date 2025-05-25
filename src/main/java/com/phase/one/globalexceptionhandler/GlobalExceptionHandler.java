package com.phase.one.globalexceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.phase.one.errorresponse.ApiErrorResponse;
import com.phase.one.exception.EmptyInputException;
import com.phase.one.exception.PersonNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<ApiErrorResponse> handleEmptyInputException(EmptyInputException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(
		        HttpStatus.NOT_FOUND,
		        ex.getMessage()
		    );
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> PersonNotFoundException(PersonNotFoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(
		        HttpStatus.NOT_FOUND,
		        ex.getMessage()
		    );
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
		
}
