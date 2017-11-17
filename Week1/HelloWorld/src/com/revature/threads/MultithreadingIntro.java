package com.revature.threads;

public class MultithreadingIntro {
	
	/*
	 * States of a thread:
	 * 
	 * New - new thread
	 * Runnable - when read to run(may be running or simply ready to run)
	 * Blocked - (aka waiting state) - when a thread is temporarily inactive
	 * 		(It is either blocked or waiting) A thread is in the blocked state
	 * 		when it tries to access a protected section of code that's currently
	 * 		locked in some other thread.
	 * Waiting - threads can be made to wait for other actions or:
	 * Timed Waiting - can call a timed wait method in threads
	 * Terminated - a thread terminates because it either finishes its thread of
	 * 		execution naturally or because some unusual or exceptional
	 * 		event occurs i.e. segmentation fault or unhandled exception.
	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		
//		ExtendsThread et = new ExtendsThread();
//
//		
//		ImplementsRunnable ir = new ImplementsRunnable();
//		Thread isThread = new Thread(ir);
//		isThread.start();
//		et.start();		
	
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("In anon Runnable");
				
				for(int i = 0; i < 100; i++) {
					
					System.out.println(i + " In AnonRunnable");
					
				}
				
			}
			
			
		};
		
		Thread anonyRun = new Thread() {
			
			public void run() {
				
				System.out.println("In anonyRun thread");
				
				for(int i = 0; i < 10; i++) {
					
					System.out.println(i + " In anonyRun thread");
					
				}
			}
			
			
		};
		
		//LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		Runnable lambda = () -> {
			System.out.println("in lambda thread");
			for(int i = 0; i < 10; i++) {
				
				System.out.println(i + " In lambda thread");
				
			}
		};
		Thread lambdaThread = new Thread(lambda);
		
		Thread anonThread = new Thread(anonRun);
		lambdaThread.start();
		System.out.println("STATE: " + anonThread.getState());
		anonThread.start();
		System.out.println("STATE: " + lambdaThread.getState());
		anonyRun.start();
		anonThread.sleep(1000);
		System.out.println("STATE: " + lambdaThread.getState());
		System.out.println("STATE: " + anonThread.getState());

		System.out.println("STATE: " + lambdaThread.getState());
		System.out.println("STATE: " + anonThread.getState());
		System.out.println("STATE: " + lambdaThread.getState());
	}
}
