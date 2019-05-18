package com.unitedremote.springboot.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unitedremote.springboot.entities.User;
import com.unitedremote.springboot.service.Webservice;

@Controller
public class WebController {
	
	@Autowired
	Webservice webservice;
   
	public String currentUser;
	
	@RequestMapping(value="/")
    public String home(Model model){
		currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("shopList", webservice.selectShops(currentUser,false));
        return "home";
    }
	
	@RequestMapping(value="/{id}")
    public String likedShop(@PathVariable Long id, Model model){
		webservice.likedShopsServ(id);
		model.addAttribute("shopList", webservice.selectShops(currentUser,false));
        return "home";
    }
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signed")
	public String signedG(@ModelAttribute("usser") User user) {
		webservice.register(user);
		return "signed";
	}
   
    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
   
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
    
    @GetMapping("/likedShops")
	public String liked(Model model) {
    	model.addAttribute("shopListliked", webservice.selectShops(currentUser,true));
		return "myprefrred";
	}
    
    @RequestMapping(value="/likedShops/{id}")
    public String dislikedShop(@PathVariable Long id, Model model){
		webservice.dislikedShopsServ(id);
		model.addAttribute("shopListliked", webservice.selectShops(currentUser,true));
        return "redirect:/likedShops";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
