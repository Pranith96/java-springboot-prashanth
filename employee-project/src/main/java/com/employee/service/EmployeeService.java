package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRegRequest;
import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;

public interface EmployeeService {

	EmployeeResponse createEmployee(EmployeeRegRequest employeeRequest);

	List<Employee> getAllEmployees(String activeTag);

	Employee getEmployeeById(String employeeId);

	String updateEmployee(EmployeeRequest employeeRequest, String empId);

	String updatePassword(String employeeId, String password);

	String deleteEmployeeById(String employeeId);

}
