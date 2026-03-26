package com.test;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="usr")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="user_id")
	private int id;
	private String u_name;
	private String u_location;
	private String u_city;
	private int u_pincode;
	private long phone;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="o_id")
	@OrderColumn(name="type")
	private List<Order> odr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_location() {
		return u_location;
	}
	public void setU_location(String u_location) {
		this.u_location = u_location;
	}
	public String getU_city() {
		return u_city;
	}
	public void setU_city(String u_city) {
		this.u_city = u_city;
	}
	public int getU_pincode() {
		return u_pincode;
	}
	public void setU_pincode(int u_pincode) {
		this.u_pincode = u_pincode;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public List<Order> getOdr() {
		return odr;
	}
	public void setOdr(List<Order> odr) {
		this.odr = odr;
	}

	

}
