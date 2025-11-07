package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.SpringConfig;
import com.kodewala.bean.Ticket;

public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	Ticket ticket = (Ticket) context.getBean(Ticket.class);
    	
    	System.out.println(ticket.getTicketId());
    	
    }
}
