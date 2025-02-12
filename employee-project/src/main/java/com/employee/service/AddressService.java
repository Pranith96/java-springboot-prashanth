package com.employee.service;

import com.employee.dto.AddressRequest;
import com.employee.model.Address;

public interface AddressService {

	Address saveAddress(AddressRequest addressRequest);

}
