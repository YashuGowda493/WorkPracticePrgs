package com.test.model;

import com.test.spring.aspects.Loggable;

public class Employee {
//	private int id;
	private String name;

	public String getName() {
		return name;
	}
	@Loggable
	public void setName(String name) {
		this.name = name;
	}
	
	public void throwException() {
		throw new RuntimeException("Dummy Exception");
	}
}
