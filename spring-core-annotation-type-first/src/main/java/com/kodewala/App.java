package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.OrderItem;
import com.kodewala.bean.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new  AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	OrderItem order = context.getBean(OrderItem.class);
    	
    	System.out.println(order.getOrderId());
    }
}
