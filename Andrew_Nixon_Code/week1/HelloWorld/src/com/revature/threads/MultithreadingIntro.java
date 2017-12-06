package com.revature.threads;

public class MultithreadingIntro {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * States of threads:
		 * New - new thread
		 * Runnable - then ready to run (may be running or waiting to run)
		 * Blocked - waiting state, waiting for another state to complete. thread is in the blocked 
		 * 		state when it tries to access a locked section of code.
		 * Waiting - threads can be made to wait for another action or;
		 * Timed Waiting - threads can be made to wait for a set period of time.
		 * Terminated - a thread terminates when it finishes or experiences exceptional event.
		 */
		
		UnderstandThreads et = new UnderstandThreads();
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread t = new Thread(ir);
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("in anonRun");
				for (int i = 0; i < 10; i++) {
					System.out.println(i + " in anonRun");
				}				
			}
			
		};
		
		Thread anonThread = new Thread(anonRun);
		
		//LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for (int i = 0; i < 10; i++) {
				System.out.println(i + " in lambda");
			}
		};
		Thread lambdaThread = new Thread(lambda);
		anonThread.setPriority(Thread.MAX_PRIORITY);
		et.setPriority(Thread.MIN_PRIORITY);
		System.out.println("STATE : " + et.getState());
		et.start();
		System.out.println("STATE : " + et.getState());
		//et.sleep(1200);
		t.start();
		System.out.println("STATE : " + et.getState());
		anonThread.start();
		System.out.println("STATE : " + et.getState());
		lambdaThread.start();
		System.out.println("STATE : " + et.getState());

	}
	
}
