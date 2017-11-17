package com.revature.threads;

public class MultiThreadingIntro {

	/*
	 *  States of a thread:
	 *  New - new thread
	 *  Runnable - when ready to run (my be running or simply ready to run at any instance
	 *  Blocked - (aka waiting state) when a thread is temporarily inactive it is either 
	 *  		blocked or waiting. A thread is in the blocked state when it tries to access a protected 
	 *  		section of code that's currently locked in some other thread
	 *  Waiting - threads can be made wait for other actions or:
	 *  Timed Waiting - can call a timed wait method in threads
	 *  Terminated - a thread terminates because either it finishes its thread
	 *  			of execution naturally or because some unusual or exceptional exent occurs.
	 *  			ie segmentations fault or handled exception
	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExtendsThread et = new ExtendsThread();
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		// Anonymous class
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("In Anonymous Class");
				for(int i = 0; i < 10; i++) {
					System.out.println(i + " in anon");
				}	
			}
		};
		Thread anonThread = new Thread(anonRun);
		
		// LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		Runnable lambda = () -> {
			System.out.println("In Lambda");
			for(int i = 0; i < 10; i++) {
				System.out.println(i + " in lambda");
			}	
		};
		
		Thread lambdaThread = new Thread(lambda);
		
		anonThread.setPriority(Thread.MAX_PRIORITY);
		et.setPriority(Thread.MIN_PRIORITY);
		System.out.println("STATE: " + et.getState());
		isThread.start();
		et.start();
		
		et.sleep(1000);

		System.out.println("STATE: " + et.getState());
		anonThread.start();	
		lambdaThread.start();
		System.out.println("STATE: " + et.getState());

	}
	

}
