package com.revature.threads;

public class ImplementsRunnable implements Runnable {
//2 out of 2 ways to make a thread
	//Runnable only has one abstract method - run - making it a functional interface
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("In implements Runnable");
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println(i + " In ImplementsRunnable");
			
		}
		
	}

}
