package com.kodewala.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean("order1")
	public Order createOrderBean() {
		
		Order order = new Order();
		order.setOrderId("1234");
		order.setItemName("Samsung S20 Ultra");
		order.setStatus("Shipped");
		return order;
		
	}
	
	@Bean("order2")
	public Order createOrder() {
		
		Order order = new Order();
		order.setOrderId("5678");
		order.setItemName("Iphone 16 pro");
		order.setStatus("Pending");
		return order;
		
	}

}
