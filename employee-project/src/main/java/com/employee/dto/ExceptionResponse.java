package com.employee.dto;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private String status;
	private String error;
	private String message;
	private StackTraceElement[]  stackTrace;
	private LocalDateTime timeStamp;

	public StackTraceElement[]  getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement[]  stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
