package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees/")
public class EmployeeController {
	private final EmployeeRepo repo;
	@Autowired
	public EmployeeController(EmployeeRepo repo) {
		this.repo=repo;
	}
	@GetMapping("signup")
	public String showSignUpForm(Employee employee) {
		return "add-employee";
	}
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("employees", repo.findAll());
		return "index";
	}
	@PostMapping("add")
	public String addEmployee(@Valid Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "add-employee";
		}
		repo.save(employee);
		return "redirect:list";
		
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable int id,Model model) {
		Employee employee=repo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid employee id:"+id));
		model.addAttribute("employee", employee);
		return "update-employee";
	}
	@PostMapping("update/{id}")
	public String updateEmployee(@PathVariable int id,@Valid Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			employee.setId(id);
			return "update-employee";
		}
		repo.save(employee);
		model.addAttribute("employees", repo.findAll());
		return "index";
	}
	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable int id,Model model) {
		Employee employee=repo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid employee is :"+id));
		repo.delete(employee);
		model.addAttribute("employees", repo.findAll());
		return "index";
	}
}
