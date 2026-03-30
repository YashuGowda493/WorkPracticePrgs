package com.test.model;

public class Customer {
	private String c_name;
	private String username;
	private String password;
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [c_name=" + c_name + ", username=" + username + ", password=" + password + "]";
	}
	

}
