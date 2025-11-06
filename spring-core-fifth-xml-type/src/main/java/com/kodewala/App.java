package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        String config = "\\com\\kodewala\\resources\\applicationContext.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
       TicketBooking tc = (TicketBooking) applicationContext.getBean("ticket");
       
       System.out.println(tc.getBookingId());
       System.out.println(tc.getName());
       System.out.println(tc.getPrice());
       
    }
}
