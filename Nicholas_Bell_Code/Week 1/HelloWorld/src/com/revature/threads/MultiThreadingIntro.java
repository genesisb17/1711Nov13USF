package com.revature.threads;

public class MultiThreadingIntro {
// to spin up a thread, 
	/*public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		et.run();
		
		ImplementsRunnable ir = new ImplementsRunnable();
		ir.run();


		This is not multithreading, its one thing running
		 then another running
	}*/
	
	/*
	 * States of a thread:
	 * New				- new thread
	 * Runnable			- When ready to run(may be running or simply ready to run at any instance)
	 * Blocked			- (aka waiting state) when a thread is temporarily blocked or waiting
	 * 					  A thread is in the blocked state when it tries to access a protected section
	 * 					  of code that is currently locked in some other thread
	 * Waiting			- threads can be made to wait for other actions or: 					  
	 * Timed Waiting	- can call a times wait method in threads
	 * Terminated		- a thread terminates because either it finishes
	 * 					  its thread of execution naturally or because some unusual
	 * 					  or exceptional even occurs. ie segmentation fault or unhandled exception
	 */
	
	public static void main(String[] args) throws InterruptedException {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		//isThread.start();
		//et.start();
		
		
		//this is an instance of a
		//class that extends runnable
		//anonymous class
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("In anonRun");
				for(int i = 0;i < 10 ; i++) {
					System.out.println(i + " in anonRun");
				}
				
			}
			
			
		};//end class impl
		Thread anonT = new Thread(anonRun);		
		//LAMBDA
		//can only be used with functional interfaces(?)
		Runnable lambda = () ->{
			System.out.println("In lambda");
			for(int i = 0;i < 10 ; i++) {
//				if (i == 5) System.out.println("STATE");
				System.out.println(i + " in lambda");
			}
		};
		
		Thread lambdaT = new Thread(lambda);
		
		anonT.setPriority(Thread.MAX_PRIORITY);
		System.out.println("STATE:" + et.getState());
		isThread.start();
		et.start();
		//et.sleep(1000);
		//System.out.println("STATE:" + et.getState());
		//et.sleep(1000);
		//anonT.start();
		//lambdaT.start();
		System.out.println("STATE:" + et.getState());
		
	}
}
