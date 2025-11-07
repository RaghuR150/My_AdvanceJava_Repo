package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Employee;
import com.kodewala.bean.SpringConfig;

class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
       Employee emp = (Employee) context.getBean("employee");
       
       System.out.println(emp.getEmpName());
    }
}
