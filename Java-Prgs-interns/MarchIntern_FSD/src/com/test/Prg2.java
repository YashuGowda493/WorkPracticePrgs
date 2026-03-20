package com.test;

 class Employee{
	 int id;
	 String name;
	 
	 public Employee() {
		 System.out.println("default constriuction");
	 }
	 public Employee(int id,String name) {
		 this.id=id;
		 this.name=name;
		 System.out.println("parametrized constructor");
	 }
	 
	 //factory method
	 public Employee getemp() {
		 return new Employee();
	 }
	 
	 public void show() {
		 System.out.println("id: "+id+" name: "+name );
	 }
 }

public class Prg2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee();
		Employee e2=e1.getemp();
//		Class.forName("com.test.Employee").newInstance();
//		Employee e3=e2.clone();

	}

}
