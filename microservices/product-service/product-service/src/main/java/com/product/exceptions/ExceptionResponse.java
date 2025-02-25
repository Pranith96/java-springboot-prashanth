package com.product.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String statusCode;
	private String error;
	private String message;
	private LocalDateTime timeStamp;
}
