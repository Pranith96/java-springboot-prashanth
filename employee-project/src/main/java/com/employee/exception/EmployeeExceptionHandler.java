package com.employee.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.dto.ExceptionResponse;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setError("NOT FOUND");
		exceptionResponse.setStatus("404");
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setTimeStamp(LocalDateTime.now());
		exceptionResponse.setStackTrace(ex.getStackTrace());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setError("Method Not Allowed");
		exceptionResponse.setStatus("405");
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setTimeStamp(LocalDateTime.now());
		exceptionResponse.setStackTrace(ex.getStackTrace());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(exceptionResponse);
	}
}
