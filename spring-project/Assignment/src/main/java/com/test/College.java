package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="colleg")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@NamedQueries({
//	@NamedQuery(name="customquery",query="from College c where c.clg_name= :name"),
//	@NamedQuery(name="cityquery",query="from College c where c.clg_city=:city")
//})

public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String clg_name;
	private String clg_city;
	private int clg_pincode;
	private int year;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClg_name() {
		return clg_name;
	}
	public void setClg_name(String clg_name) {
		this.clg_name = clg_name;
	}
	public String getClg_city() {
		return clg_city;
	}
	public void setClg_city(String clg_city) {
		this.clg_city = clg_city;
	}
	public int getClg_pincode() {
		return clg_pincode;
	}
	public void setClg_pincode(int clg_pincode) {
		this.clg_pincode = clg_pincode;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", clg_name=" + clg_name + ", clg_city=" + clg_city + ", clg_pincode="
				+ clg_pincode + ", year=" + year + "]";
	}
	

}
