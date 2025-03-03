package com.employee.dto;

import com.employee.model.Gender;

import lombok.Data;

@Data
public class EmployeeRequest {

	private String name;

	private String mobileNumber;

	private Integer age;

	private String emailId;

	private Gender gender;

	private String password;
}
