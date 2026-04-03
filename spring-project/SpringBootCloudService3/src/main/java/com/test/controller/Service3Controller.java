package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service3")
public class Service3Controller {
	@GetMapping("/cards")
	public String cardPayments() {
		return "Service 3 controller ac card Payments operation";
	}
	
}
