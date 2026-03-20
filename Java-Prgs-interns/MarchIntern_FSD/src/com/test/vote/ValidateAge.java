package com.test.vote;

public class ValidateAge {
	public void checkAge(int age) {
		if(age<=18) {
//			throw new AgeValidationException("Age should be 18+");
			
		}else {
			System.out.println("Valid age to vote");
		}
	}

}
