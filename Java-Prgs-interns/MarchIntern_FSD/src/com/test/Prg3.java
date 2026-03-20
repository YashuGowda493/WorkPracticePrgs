package com.test;

class TestThread extends Thread{
	public void run() {
		System.out.println("Thread is running");
		try {
			Thread.sleep(3000);
			System.out.println("Thread is running after 3 sec ");
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

public class Prg3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread t1=new TestThread();
		t1.start();
		System.out.println("Main thread is running");
		try {
			Thread.sleep(500);
			System.out.println("Main thread runs after half");
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
