package com.revature.threads;

public class ImplementsRunnable implements Runnable {

	/*
	 *  Second way of two to make a thread
	 *  
	 *  Since Runnable is an interface with only one method, it is known as a functional interface
	 *  
	 *  Implementing runnable allows you to extend another class, whereas you cannot do that if 
	 *  you have already extended the Thread class.
	 */
	
	@Override
	public void run() {
		
		System.out.println("In ImplementsRunnable");
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in ImplementsRunnable");
		}
		
	}

}
