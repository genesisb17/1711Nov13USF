package com.revature.threads;

public class ImplementsRunnable implements Runnable{
	// 2 out of the two ways to make a thread
	// runnable only has one abstract method - run - making it a functional interface
	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		for (int i = 0; i < 10; ++i) {
			System.out.println(i + " In ImplementsRunnable");
		}
		
	}

}
