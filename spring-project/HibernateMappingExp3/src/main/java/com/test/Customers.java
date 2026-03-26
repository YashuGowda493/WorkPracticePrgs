package com.test;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cust")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String c_name;
	private String c_location;

	@ManyToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinTable(name="cst_ord",
			joinColumns= {@JoinColumn(name="c_id")},
			inverseJoinColumns = {@JoinColumn(name="o_id")}
	)
	
	private List<Order> order;

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_location() {
		return c_location;
	}

	public void setC_location(String c_location) {
		this.c_location = c_location;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", c_name=" + c_name + ", c_location=" + c_location + ", order=" + order + "]";
	}

}
