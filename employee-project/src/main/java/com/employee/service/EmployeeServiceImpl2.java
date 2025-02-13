package com.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dto.EmployeeRegRequest;
import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

import io.micrometer.common.util.StringUtils;

@Primary
@Service(value = "service2")
public class EmployeeServiceImpl2 implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponse createEmployee(EmployeeRegRequest employeeRequest) {
		Employee response = employeeRepository.save(convertEmpDtoToEntity(employeeRequest.getEmpRequest()));
		if (response == null) {
			return null;
		}
		return convertEmpReponseToDto(response);
	}

	private EmployeeResponse convertEmpReponseToDto(Employee response) {
		EmployeeResponse empResponse = new EmployeeResponse();
		empResponse.setEmpId(response.getEmpId());
		empResponse.setMessage("Successfully saved");
		return empResponse;
	}

	private Employee convertEmpDtoToEntity(EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		employee.setName(employeeRequest.getName());
		employee.setAge(employeeRequest.getAge());
		employee.setEmailId(employeeRequest.getEmailId());
		employee.setEmpId(generateEmpId());
		employee.setGender(employeeRequest.getGender());
		employee.setMobileNumber(employeeRequest.getMobileNumber());
		employee.setPassword(employeeRequest.getPassword());
		employee.setStatus("ACTIVE");
		return employee;
	}

	private String generateEmpId() {
		Random random = new Random();
		int num = random.nextInt(1111, 9999);
		String employeeId = "JKDF" + num;
		return employeeId;
	}

	@Override
	public List<Employee> getAllEmployees(String activeTag) {
		List<Employee> results = null;

		if (StringUtils.isNotBlank(activeTag)) {
			if ("Y".equals(activeTag)) {
				results = employeeRepository.findAll().stream().filter(emp -> emp.getStatus().equals("ACTIVE"))
						.collect(Collectors.toList());
			} else if ("N".equals(activeTag)) {
				results = employeeRepository.findAll().stream().filter(emp -> emp.getStatus().equals("INACTIVE"))
						.collect(Collectors.toList());
			}
		} else {
			results = employeeRepository.findAll();
		}
		if (results == null || results.isEmpty()) {
			throw new RuntimeException("No records found");
		}
		return results;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		// Optional<Employee> response = employeeRepository.findById(primaryKeyValue);
		Optional<Employee> response = employeeRepository.findByEmpId(employeeId);
		if (!response.isPresent()) {
			throw new EmployeeNotFoundException("No records found for emp id");
		}
		return response.get();
	}

	@Transactional
	@Override
	public String updateEmployee(EmployeeRequest employeeRequest, String empId) {
		Employee response = getEmployeeById(empId);

		if (StringUtils.isNotBlank(employeeRequest.getName())) {
			response.setName(employeeRequest.getName());
		}
		if (StringUtils.isNotBlank(employeeRequest.getMobileNumber())) {
			response.setMobileNumber(employeeRequest.getMobileNumber());
		}

		if (employeeRequest.getAge() != null && employeeRequest.getAge() > 0) {
			response.setAge(employeeRequest.getAge());
		}
		if (StringUtils.isNotBlank(employeeRequest.getEmailId())) {
			response.setEmailId(employeeRequest.getEmailId());
		}

		Employee updatedResponse = employeeRepository.save(response);
		if (updatedResponse == null) {
			return null;
		}
		return "Updated successfully";
	}

	@Transactional
	@Override
	public String updatePassword(String employeeId, String password) {
		// String status = "INACTIVE";
		// employeeRepository.deactiveEmployee(employeeId, status);

		employeeRepository.updatePassword(employeeId, password);

		return "updated successfully";
	}

	@Transactional
	@Override
	public String deleteEmployeeById(String employeeId) {
		// getEmployeeById(employeeId);
		// employeeRepository.deleteByEmpId(employeeId);
		Employee response = getEmployeeById(employeeId);
		employeeRepository.delete(response);
		return "Deleted successfully";
	}
}
