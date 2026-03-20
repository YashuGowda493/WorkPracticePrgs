package com.test;

class Threaddemo implements Runnable{
	public void run() {
		try {
			System.out.println("Thread started");
			Thread.sleep(4000);
			System.out.println("After 1 sec thread executed");
		}catch(Exception e) {
			
		}
	}
}
public class ForRunnableInterface {
	
	public static void main(String[] args) {
		Threaddemo t1=new Threaddemo();
		Thread t2=new Thread(t1);t2.start();
		
		
	}

}
