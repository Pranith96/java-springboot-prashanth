package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRegRequest;
import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Qualifier(value = "service1")
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/get")
	public String message() {
		return "Hello world spring";
	}

	@GetMapping("/data")
	public String welcome() {
		return "Hello welcome to java";
	}

	@PostMapping("/save")
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRegRequest employeeRegRequest) {
		EmployeeResponse response = employeeService.createEmployee(employeeRegRequest);
		if (response == null) {
			EmployeeResponse empResponse = new EmployeeResponse();
			empResponse.setEmpId(null);
			empResponse.setMessage("Data not saved");
			// return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new
			// EmployeeResponse(null, "Data not saved"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployeeRecords(
			@RequestParam(value = "activeTag", required = false) String activeTag) {
		List<Employee> response = employeeService.getAllEmployees(activeTag);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String employeeId) {
		Employee response = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable("empId") String empId) {
		String response = employeeService.updateEmployee(employeeRequest, empId);
		if (response == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data not updated");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/update/password/{employeeId}")
	public ResponseEntity<String> updatePassword(@PathVariable("employeeId") String employeeId, @RequestParam("password") String password) {
		String response = employeeService.updatePassword(employeeId, password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("employeeId") String employeeId) {
		String response = employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	// Deactive Employee api: update status with employeeId /employee/deactive?empId=1234
}
