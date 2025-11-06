package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
	
	String config = "\\com\\kodewala\\resources\\applicationContext.xml";
      ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config) ;
      
      Account account =  (Account) applicationContext.getBean("acc");
      
      System.out.println(account.getAccountNumber());
      System.out.println(account.getAddress());
      System.out.println(account.getIfsc());
    }
}
