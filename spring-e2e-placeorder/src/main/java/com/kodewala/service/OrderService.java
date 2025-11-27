package com.kodewala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.bean.OrderInfo;
import com.kodewala.dao.OrderDAO;
import com.kodewala.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	public int createOrder(OrderInfo orderInfo) {
		/* System.out.println("OrderService.createOrder()........."); */
		Order order = new Order();
		order.setItemName(orderInfo.getItemName());
		order.setQty(orderInfo.getQty());
		order.setPrice(orderInfo.getPrice());
		order.setAddress(orderInfo.getAddress());;
		
	int orderId = orderDAO.saveOrder(order);
	return orderId;
	}

}
