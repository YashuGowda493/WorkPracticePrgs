package com.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "email is required")
	private String email;
//	@NotEmpty(message = "phoneNo is required")
	private long phoneNo;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String email, long phoneNo) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}
