package com.kodewala.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean("ticket")
	public Ticket createTicketBean() {
		Ticket ticket = new Ticket();
		ticket.setTicketId("123456789");
		return ticket;
	}

}
