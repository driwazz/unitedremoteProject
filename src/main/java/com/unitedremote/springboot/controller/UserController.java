package com.unitedremote.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unitedremote.springboot.entities.User;
import com.unitedremote.springboot.service.AuthorityService;
import com.unitedremote.springboot.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService uservice; 
	@Autowired
	UserService authservice;
	
	
	@GetMapping("/signed")
	public String signedG() {
		return "signed";
	}
	
	@PostMapping("/signed")
	public String signedP(@ModelAttribute("userr") User user) {
		uservice.insert(user);
		authservice.insertauth(user);
		return "signed";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model theModel) {
		return "signup";
	}


}