package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Mycontroller {
	@RequestMapping("/login")
	public String login() {
		System.out.println("Mycontroller.login():::::::::::::::::::::::");
		return "login";
	}
	@RequestMapping("/validateLogin")
	public String validateLogin(@RequestParam("username") String userName, @RequestParam("password") String password) {
		System.out.println("UserName is : "+userName);
		System.out.println("Password is : "+password);
		return "loginSuccess";
	}
	
}
