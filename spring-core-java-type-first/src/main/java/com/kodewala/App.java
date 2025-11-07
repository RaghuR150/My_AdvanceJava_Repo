package com.kodewala;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Order;
import com.kodewala.bean.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Order order = (Order) context.getBean("order1");
        
        System.out.println(order.getOrderId());
        System.out.println(order.getItemName());
        System.out.println(order.getStatus());
        
       Order order2 =  (Order) context.getBean("order2");
       System.out.println(order2.getOrderId());
       System.out.println(order2.getItemName());
       System.out.println(order2.getStatus());
       
    }
}
