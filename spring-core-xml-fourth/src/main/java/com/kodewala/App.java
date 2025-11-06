package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {	
	String config = "\\com\\kodewala\\resources\\applicationContext.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
       Employee employee = (Employee) applicationContext.getBean("emp");
       
       System.out.println(employee.getEmployeeId());
       System.out.println(employee.getEmployeeName());
       System.out.println(employee.getSalary());
    }
}
