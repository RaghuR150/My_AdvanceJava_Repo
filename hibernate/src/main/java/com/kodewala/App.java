package com.kodewala;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kodewala.entity.Payment;


public class App 
{
    public static void main( String[] args )
    {

    	Configuration cfg = new Configuration();
    	
    	cfg.configure("\\com\\kodewala\\configuration\\hibernate-cfg.xml");
    	
    	SessionFactory sessionFactory = cfg.buildSessionFactory();
    	
    	  Session session = sessionFactory.openSession();
    	  
    	 Transaction txt = session.beginTransaction();
    	 
    	 Payment payment = new Payment();
    	 payment.setAmount(1500);
    	 payment.setDescription("this is iphone 16 pro");
    	 payment.setSentBy("Raghu");
    	 payment.setStatus("PENDING");
    	 
    	 session.save(payment);
    	 
    	 txt.commit();
    	 
    	 
    	
    	
    	
    	
    }
}
