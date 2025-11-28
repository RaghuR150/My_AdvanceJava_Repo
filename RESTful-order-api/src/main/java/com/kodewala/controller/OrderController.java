package com.kodewala.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.bean.OrderInfo;

@RestController
public class OrderController {
	
	@PostMapping("/placeOrder")
	public ResponseEntity placeOrder(@RequestBody OrderInfo orderInfo ) {
		System.out.println("Item Name: "+orderInfo.getItemName()+" "+"Price: "+orderInfo.getPrice());
		
		return ResponseEntity.ok("Order Received");
	}

}
