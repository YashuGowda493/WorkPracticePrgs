package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name="privateclg")
//@DiscriminatorValue("pvtclg")
public class PrivateClg extends College{
	private int fees;

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
	
}
