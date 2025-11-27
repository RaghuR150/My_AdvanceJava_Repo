package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodewala.bean.OrderInfo;
import com.kodewala.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/showOrderPage")
	public String showOrder() {
		System.out.println("showing  order page......");
		return "order";
	}
	@RequestMapping("/placeOrder")
	public String palceOredr(@ModelAttribute OrderInfo orderInfo , Model model) {
		/*
		 * System.out.println("OrderController.palceOredr().......");
		 */
		int orderId = orderService.createOrder(orderInfo);
		model.addAttribute("orderId", orderId);
		
		return "order-success";
	}
	

}
