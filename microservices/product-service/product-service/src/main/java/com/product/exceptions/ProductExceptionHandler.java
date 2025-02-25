package com.product.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleProductNotFoundException(ProductNotFoundException ex) {
		ExceptionResponse response = ExceptionResponse.builder().statusCode("404").error("Not Found")
				.message(ex.getMessage()).timeStamp(LocalDateTime.now()).build();
		return ResponseEntity.ok(response);
	}
}
