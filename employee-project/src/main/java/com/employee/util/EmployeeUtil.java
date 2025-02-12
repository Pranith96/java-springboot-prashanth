package com.employee.util;

import org.springframework.stereotype.Component;

import com.employee.dto.AddressRequest;
import com.employee.model.Address;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeUtil {

	public Address convertAddressDtoToEntity(AddressRequest addressRequest) {
		Address ad = new Address();

		ad.setCity(addressRequest.getCity());
		ad.setPincode(addressRequest.getPincode());
		ad.setPlotNo(addressRequest.getPlotNo());
		ad.setState(addressRequest.getState());
		ad.setEmpId(addressRequest.getEmpId());

		Address ad1 = Address.builder().city(addressRequest.getCity()).pincode(addressRequest.getPincode())
				.plotNo(addressRequest.getPlotNo()).state(addressRequest.getState()).empId(addressRequest.getEmpId())
				.build();
		log.info("Address request: {} ", ad1);
		log.info(String.format("Adress plotNo %s and pincode %s", ad1.getPlotNo(), ad1.getPincode()));

		return ad1;
	}
}
