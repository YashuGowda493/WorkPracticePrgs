package com.test;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="odr")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="o_id")
	private int id;
	private String o_name;
	private int o_price;
	private int o_quant;
	
	
	@ManyToOne
//	(fetch=FetchType.LAZY)
//	@JoinColumn(name="user_id",nullable=true)
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	public int getO_quant() {
		return o_quant;
	}
	public void setO_quant(int o_quant) {
		this.o_quant = o_quant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
