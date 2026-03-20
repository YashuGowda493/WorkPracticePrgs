package com.test.vote;

import java.util.Scanner;

public class Voting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the age");
		int age=sc.nextInt();
		ValidateAge ag=new ValidateAge();
		ag.checkAge(age);

	}

}
