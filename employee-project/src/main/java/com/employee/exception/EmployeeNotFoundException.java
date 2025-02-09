package com.employee.exception;

public class EmployeeNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
