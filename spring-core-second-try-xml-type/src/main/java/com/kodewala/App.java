package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {	
	String config = "\\com\\kodewala\\resources\\applicationContext.xml";
       ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
      Product product = (Product) applicationContext.getBean("prod");
      
      System.out.println(product.getProductName());
      System.out.println(product.getProductDescription());
      System.out.println(product.getProductPrice());
    }
}
