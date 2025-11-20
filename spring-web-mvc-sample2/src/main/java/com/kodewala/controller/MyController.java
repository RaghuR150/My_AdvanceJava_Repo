package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("Logged in.......");
		return "login";
	}
	
	
	
	

}
