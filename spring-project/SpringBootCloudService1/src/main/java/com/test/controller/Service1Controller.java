package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1Controller {
	@GetMapping("/openac")
	public String accCreateService() {
		return "Service 1 controller ac create operation";
	}
	
}
