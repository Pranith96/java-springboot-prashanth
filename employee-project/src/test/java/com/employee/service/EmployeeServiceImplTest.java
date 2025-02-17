package com.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.employee.dto.AddressRequest;
import com.employee.dto.EmployeeRegRequest;
import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.model.Gender;
import com.employee.repository.EmployeeRepository;

//@ExtendWith(MockitoJunitRunner.class)
//@RunWith(MockitoJunitRunner.class)
@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl mockEmployeeServiceImpl;

	@Mock
	EmployeeRepository mockEmployeeRepository;

	@Mock
	AddressService mockAddressService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mocks
	}

	@Test
	public void testGetEmployeeById() {

		Employee emp = new Employee();
		emp.setEmpId("1");

		String id = "1";
		Mockito.when(mockEmployeeRepository.findByEmpId(id)).thenReturn(Optional.of(emp));
		emp = mockEmployeeServiceImpl.getEmployeeById(id);
		assertEquals("1", emp.getEmpId());
	}

	@Test
	void testGetEmployeeById_EmployeeNotFound() {
		// Arrange: Mock the repository to return empty
		when(mockEmployeeRepository.findByEmpId("123")).thenReturn(Optional.empty());

		// Act & Assert: Expecting an exception to be thrown
		EmployeeNotFoundException exception = assertThrows(EmployeeNotFoundException.class, () -> {
			mockEmployeeServiceImpl.getEmployeeById("123");
		});

		// Assert: Verify that the exception message is correct
		assertEquals("No records found for emp id", exception.getMessage());

		// Verify that the repository method was called
		verify(mockEmployeeRepository).findByEmpId("123");
	}

	@Test
	public void testCreateEmployee() {

		EmployeeRegRequest request = new EmployeeRegRequest();
		AddressRequest addressRequest = new AddressRequest();
		addressRequest.setCity("HYD");
		addressRequest.setEmpId("123");
		addressRequest.setPincode(123456);
		addressRequest.setPlotNo("2345");
		addressRequest.setState("UH");
		EmployeeRequest empRequest = new EmployeeRequest();
		empRequest.setAge(12);
		empRequest.setEmailId("ABC@gmail.com");
		empRequest.setGender(Gender.MALE);
		empRequest.setMobileNumber("12345678");
		empRequest.setName("ABC");
		empRequest.setPassword("4w53534");
		request.setEmpRequest(empRequest);
		request.setAddressRequest(addressRequest);

		Employee emp = new Employee();
		emp.setEmpId("123");
		Mockito.when(mockEmployeeRepository.save(emp)).thenReturn(emp);
		Mockito.when(mockAddressService.saveAddress(addressRequest)).thenReturn(new Address());

		EmployeeResponse response = mockEmployeeServiceImpl.createEmployee(request);
		assertEquals("123", response.getEmpId());// Assert
        assertNotNull(response);
//        assertEquals("JKDF1234", response.getEmpId());
//        assertEquals("Successfully saved", response.getMessage());
//
//        // Verify that the repository and service methods were called
//        verify(employeeRepository).save(any(Employee.class));
//        verify(addressService).saveAddress(any(AddressRequest.class));;
	}
}
