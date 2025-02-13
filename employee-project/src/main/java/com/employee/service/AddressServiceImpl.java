package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.AddressRequest;
import com.employee.model.Address;
import com.employee.repository.AddressRepository;
import com.employee.util.EmployeeUtil;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	EmployeeUtil employeeUtil;

	@Override
	public Address saveAddress(AddressRequest addressRequest) {
		Address request = employeeUtil.convertAddressDtoToEntity(addressRequest);
		Address address = addressRepository.save(request);	
		if (address == null) {
			return null;
		}
		return address;
	}

}
