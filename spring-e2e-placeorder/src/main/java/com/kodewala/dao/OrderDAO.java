package com.kodewala.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kodewala.entity.Order;



@Repository
public class OrderDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public int saveOrder(Order order) {
		
		/*
		 * System.out.println("OrderDAO.saveOrder()...........");
		 * System.out.println("Order price: "+order.getPrice());
		 */
		
		Session session = sessionFactory.openSession();
	    Transaction txt = session.beginTransaction();
	    int orderId = (int) session.save(order);
	    txt.commit();
	    return orderId;
		
		
	}

}
