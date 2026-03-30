package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@GetMapping("/userform")
	public String userLoginForm() {
		
		return "loginpage";
		
	}
	@GetMapping("/submit")
//	public String userSubmitForm(HttpServletRequest request,Model model,User user) {
//		String usr=request.getParameter("user");
//		String pass=request.getParameter("pwd");
	public String userSubmitForm(@RequestParam("user")String usr,@RequestParam("pwd")String pass,Model model,User user) {
		user.setUsername(usr);
		user.setPassword(pass);
		model.addAttribute("data",user);
		if(usr.equals(user.getUsername())&& pass.equals(user.getPassword())) {
			return "success";
		}
		else {
			return "loginpage";
		}
		
		
		
	}

}
