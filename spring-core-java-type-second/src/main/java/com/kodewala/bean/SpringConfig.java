package com.kodewala.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean("employee")
	public Employee createEmployeeBean() {
		
		Employee emp = new Employee();
		emp.setEmpName("Raghu");
		return emp;
	}

}
