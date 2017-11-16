package com.revature.threads;

public class MultithreadingIntro {
	/*
	 * States of a thread:
	 * New - new thread
	 * Runnable - when ready to run (may be ready to run at any instance or running)
	 * Blocked - when a thread is temporarily inactive it is either blocked or waiting
	 * 		A thread is in the blocked state when it tires to access a protected section of 
	 *  	code that's currently locked in some other thread
	 * Waiting - threads can be made to wait for other actions or:
	 * Timed Waiting - threads can call a timed wait method
	 * Terminated - a thread terminates because it either finishes its 
	 *  	thread of execution naturally or an exceptional event occurs ie: segmentation fault
	 *  	or unhandled exception
	 */
	public static void main(String[] args) throws InterruptedException {
//		/* not multi threading */
//		ExtendsThread et = new ExtendsThread();
//		et.run();
//		/* also not multithreading */
//		ImplementsRunnable ir = new ImplementsRunnable();
//		ir.run();
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir); // ImplementsRunnable doesn't have start method
										  // must be attached to thread
		
		//anonymous class to extend run()
		Runnable anonRun = new Runnable() { 
			@Override
			public void run() {
				System.out.println("In anonymous class implementation");
				for (int i = 0; i < 10; ++i) {
					System.out.println(i + " In anonymous class implementation");
				}
			}
		};
		Thread anonThread = new Thread(anonRun);
		
		Thread exThread = new Thread() {
			// implement() run here
		};
		
		//LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for (int i = 0; i < 10; ++i) {;
				System.out.println(i + " in lambda");
			}
		};
		Thread lambdaThread = new Thread(lambda);

		anonThread.setPriority(Thread.MAX_PRIORITY);
		et.setPriority(Thread.MIN_PRIORITY);
		System.out.println("STATE: " + et.getState());		
		isThread.start();
		et.start();
		System.out.println("STATE: " + et.getState());
		anonThread.start();
		lambdaThread.start();
		System.out.println("STATE: " + et.getState());
	}

}
