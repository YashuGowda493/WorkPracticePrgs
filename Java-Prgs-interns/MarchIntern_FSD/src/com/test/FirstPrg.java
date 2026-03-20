package com.test;

interface Inf1{
	float pi=3.14f;//public static final
	void display();
	default void show() {
		System.out.println("Default inf");
	}
	
	static void userLogin() {
		System.out.println("static inf");
	}
	
}

interface Inf2{
	void dog();
}

abstract class Abs{
	public abstract void cat();
	public void fox() {
		System.out.println(" fox abs implemented");
	}
	
}

class Impleme extends Abs implements Inf1,Inf2{
	@Override
	public void display() {
		System.out.println("display of inf1");
	}
	@Override
	public void dog() {
		System.out.println("Dog method from inf2");
	}
	public void cat() {
		System.out.println("Cat method of abs");
	}
	
	
}

public class FirstPrg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Impleme obj1=new Impleme();
		obj1.display();
		obj1.dog();
		obj1.cat();
		obj1.fox();
		obj1.show();
		Inf1.userLogin();
		

	}

}
