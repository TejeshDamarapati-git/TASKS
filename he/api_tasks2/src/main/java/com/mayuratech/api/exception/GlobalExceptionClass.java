package com.mayuratech.api.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mayuratech.api.payload.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionClass extends ResponseEntityExceptionHandler{
	

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest) {
		ErrorDetails ed = new ErrorDetails(new Date(),exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest webRequest) {
		ErrorDetails ed = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
