package com.revature.threads;

public class ImplementsRunnable implements Runnable{

	// 2 out of 2 ways to make a thread. Runnable has a functional interface, meaning it has one 
	// abstract method
	@Override
	public void run() {
		System.out.println("in ImplementsRunnable");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " in ImplementsRunnable");
		}
	}

}
