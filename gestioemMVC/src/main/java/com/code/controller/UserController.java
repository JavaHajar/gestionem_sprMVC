package com.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.entities.User;
import com.code.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	 private UserService userService;
	@Autowired
	private User user;

	@RequestMapping("/")
  
  public String showLogin(Model model) {
		model.addAttribute("user", user);
      return "login";
   }

}
