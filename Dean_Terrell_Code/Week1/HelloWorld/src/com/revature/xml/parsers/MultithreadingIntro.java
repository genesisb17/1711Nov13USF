package com.revature.xml.parsers;

public class MultithreadingIntro {

	public static void main(String[] args) {
		
		/*Pros
		 * Runnable allows you to extend other classes
		 * 
		 * Cons
		 * Runnable requires you to create a Thread object in order to use start()
		 * 
		 * States of a thread:
		 * New - new thread
		 * Runnable - when ready to run (may be running or simply ready to run at any instance)
		 * Blocked - (aka waiting state) when a thread is temporarily inactive it is either
		 * 	blocked or waiting. A thread is blocked when it tries to access a protected section of code
		 * Waiting - threads can be made to wait for other actions or:
		 * Timed Waiting - can call a timed wait method in threads
		 * Terminated - a thread terminates because either it naturally finishes executing or
		 * 	because some unusual or exceptional event occurs (segmentation fault etc.)
		 */
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread thread = new Thread(ir);
		
		Runnable lambda = () -> {
			
		};
		et.start();
		System.out.println("STATE: " + et.getState());
		//thread.start();
	}

}
