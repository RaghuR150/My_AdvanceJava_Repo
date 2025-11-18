package com.kodekart.dao;

import com.kodekart.model.Order;
import com.kodekart.model.OrderItem;

import java.sql.Connection;
import java.util.List;

public interface OrderDao {
	int createOrder(Connection con, Order order);

	int addOrderItems(Connection con, int orderId, List<OrderItem> items);

	List<Order> getOrdersByUser(int userId);

	List<Order> getAllOrders();
}
