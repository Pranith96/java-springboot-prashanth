package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Data
@Builder
public class AddressRequest {

	private String plotNo;
	private String city;
	private String state;
	private Integer pincode;
	private String empId;

}
