package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.Customer;

@Controller
public class Logincontroller {
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String homepage() {
		return "homepage";
	}
	@GetMapping("/greet")
	public String greetAgain() {
		return "greetpage";
	}
	@GetMapping("/login")
	public String login() {
		return "loginpage";
	}
	@GetMapping("/submit")
	public String userSubmitForm(@RequestParam("name")String name,@RequestParam("user")String usr,@RequestParam("pwd")String pass,Model model,Customer cust) {
		cust.setC_name(name);
		cust.setUsername(usr);
		cust.setPassword(pass);
		model.addAttribute("data",cust);
		if(name.equals(cust.getC_name())&& usr.equals(cust.getUsername())&& pass.equals(cust.getPassword())) {
			return "success";
		}
		else {
			return "loginpage";
		}
		
		
		
	}
}
