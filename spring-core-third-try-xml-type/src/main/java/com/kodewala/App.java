package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {	
	String config = "\\com\\kodewala\\resources\\applicationContext.xml";
       ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
      Order order = (Order) applicationContext.getBean("ord");
      
      System.out.println(order.getOrderId());
      System.out.println(order.getOrderName());
      System.out.println(order.getPrice());
    }
}
