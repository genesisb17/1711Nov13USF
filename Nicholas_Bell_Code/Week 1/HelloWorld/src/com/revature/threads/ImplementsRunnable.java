package com.revature.threads;

public class ImplementsRunnable implements Runnable{
	//2 out of 2 ways to make a thread
	//Runnable only has one abstract method - run - making it a 
	//functional interface
	@Override
	public void run() {
		System.out.println("In ExtendsRunnable");
		for(int i = 0;i < 10 ; i++) {
			System.out.println(i + " in ExtendsRunnable");
		}
		
	}

}
