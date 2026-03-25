package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name="govtclg")
//@DiscriminatorValue("govtclg")
public class GovtClg extends College{
	private int schlorship;

	public int getSchlorship() {
		return schlorship;
	}

	public void setSchlorship(int schlorship) {
		this.schlorship = schlorship;
	}

	
	
}
