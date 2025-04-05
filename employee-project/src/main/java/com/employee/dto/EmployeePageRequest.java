package com.employee.dto;

import lombok.Data;

@Data
public class EmployeePageRequest {

	private String empName;

	private Integer pageNumber;

	private Integer pageSize;

	private String sort;
}

//select * from employee where (:empName is NULL or empName = :empName)

