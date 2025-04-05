package com.employee.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByEmpId(String employeeId);

	@Modifying
	@Query("Update Employee e set e.password=:password where e.empId=:employeeId")
	void updatePassword(String employeeId, String password);

	void deleteByEmpId(String employeeId);

	Page<Employee> findByName(String empName, Pageable pageable);

	// Optional<Employee> findByName(String password);
	// Optional<Employee> findByNameAndPassword(String name, String password);
	// Optional<Employee> findByNameAndPasswordOrderByDesc(String name, String
	// password);
	// Optional<Employee> findByEmpIdAndPassword(String employeeId, String
	// password);

}
