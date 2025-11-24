package com.kodewala.mmt.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodewala.mmt.profile.bean.UserProfile;

@Controller
public class ProfileController {
	@RequestMapping("/showProfilePage")
	public String showProfile() {
		System.out.println("showing profile.......");
		return "profile";
	}
	@PostMapping("/createProfile")
	public String createProfile(@ModelAttribute UserProfile userProfile, Model model) {
		System.out.println("First Name: "+userProfile.getFirstName());
		System.out.println("Last Name: "+userProfile.getLastName());
		System.out.println("Email: "+userProfile.getEmail());
		System.out.println("Mobile: "+userProfile.getMobile());
		
		String email = userProfile.getEmail();
		String mobile = userProfile.getMobile();
		String userId = generateUserId(email, mobile);
		System.out.println("User ID is: "+userId);
		
		model.addAttribute("userId", userId);
		
		
		return "profileSuccess";
	}
	
	
	 public static String generateUserId(String email, String mobile) {
	        String emailPart = email.substring(0, email.indexOf("@"));
	        String mobilePart = mobile.substring(mobile.length() - 4);

	        return emailPart + mobilePart;
	    }

}
