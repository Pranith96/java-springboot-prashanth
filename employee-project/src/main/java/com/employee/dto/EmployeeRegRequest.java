package com.employee.dto;

import lombok.Data;

@Data
public class EmployeeRegRequest {

	private AddressRequest addressRequest;
	private EmployeeRequest empRequest;
}
