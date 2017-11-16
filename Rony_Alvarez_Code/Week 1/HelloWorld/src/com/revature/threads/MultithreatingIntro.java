package com.revature.threads;

public class MultithreatingIntro {
	
	/*
	 * states of a thread:
	 * New - new thread
	 * Runnable - when ready to run
	 * Blocked - aka waiting state, when it tries to access a protected section of code that's corrently locked
	 * Waiting - thread can be made to wait for other actions or
	 * Timed Waiting - can call a time wawit method on threads
	 * Terminated - when a thread terminates or something happens that forces it to terminate
	 */

	public static void main(String[] args) throws InterruptedException {
		
		ExtensThread et = new ExtensThread();
		
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("In anonymous class implementation");
				for(int i = 0; i <10; i++) {
					System.out.println(i + "in anon");
				}
				
			}
			
		};
		
		Thread anonThread = new Thread(anonRun);
		
		//LAMBDA
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for(int i = 0; i <10; i++) {
				System.out.println(i + "in lambda");
			}
		};
		
		Thread lambdaThread = new Thread(lambda);
		
		
		anonThread.setPriority(Thread.MAX_PRIORITY);
		isThread.start();
		et.start();
		et.sleep(1000);
		anonThread.start();
		
	}

}
