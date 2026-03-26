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
	public List<Order> getOdr() {
		return odr;
	}
	public void setOdr(List<Order> odr) {
		this.odr = odr;
	}

	

}
