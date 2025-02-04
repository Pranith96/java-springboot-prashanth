package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmpId(String employeeId);
	
	//	Optional<Employee> findByName(String password);
	//	Optional<Employee> findByNameAndPassword(String name, String password);
	//	Optional<Employee> findByNameAndPasswordOrderByDesc(String name, String password);
	//Optional<Employee> findByEmpIdAndPassword(String employeeId, String password);


}
