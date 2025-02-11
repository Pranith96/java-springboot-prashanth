package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile(value = {"dev", "qa","prod"})
@Profile(value = "!dev")
public class EmployeeConfig {

	@Bean
	public String getData() {
		return "Hello";
	}
}
