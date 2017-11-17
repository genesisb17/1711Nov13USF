package com.revature.threads;

public class MultithreadingIntro {
	/*
	 * States of a thread:
	 * New - thread
	 * Runnable - when ready to run (may be running or simply ready to run at any instance)
	 * Blocked - (aka waiting state) - when a thread is temporarily inactive it is either
	 * blocked or waiting. A thread is in the blocked styate when it tries to access a
	 * protected section that's currently locked in some other thread.
	 * Waiting - threads can be made to wait for other actions or:
	 * Timed Waiting - can call a timed wait method in threads
	 * Terminated - a thread terminates because either it finishes its thread of execution
	 *  naturally or because some unusual or exceptional event occurs. ie segmentation 
	 *  fault non-handled exception
	 */
	
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		Runnable anonRun = new Runnable() {
			// anonymous class
			@Override
			public void run() {
				System.out.println("In anonymous class implementation");
				for(int i = 0; i < 10; i++) {
					System.out.println(i + " in anon");
				}
			}
		};
		
		Thread anonThread = new Thread(anonRun);
		
		// LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for (int i = 0; i < 10; i++) {
				System.out.println(i + " in lambda");
			}
			
		};
		Thread lambdaThread = new Thread(lambda);
		
		anonThread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("STATE: " + et.getState());
		et.start();
		isThread.start();
		System.out.println("STATE: " + et.getState());
		anonThread.start();
		lambdaThread.start();
		System.out.println("STATE: " + et.getState());
	}
}
