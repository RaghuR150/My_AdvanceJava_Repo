package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("MyController.login()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginPage");
		return mv;
		
	}

}
