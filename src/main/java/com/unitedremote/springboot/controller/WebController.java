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
	
	@RequestMapping(value="/")
    public String home(){
        return "home";
    }
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@GetMapping("/signed")
	public String signedG() {
		return "signed";
	}
   
    @RequestMapping(value="/user")
    public String user(){
        return "user";
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
	public String liked() {
		
		return "myprefrred";
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
