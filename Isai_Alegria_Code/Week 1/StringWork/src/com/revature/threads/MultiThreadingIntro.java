package com.revature.threads;

public class MultiThreadingIntro {
	
	/* 
	 * States of a thread:
	 * New - new thread
	 * Runnable - when ready to run (may be running or simply
	 * ready to run at any instance)
	 * Blocked - (aka waiting state) - when a thread is temporarily
	 * inactive it is either blocked or waiting. A thread is in the blocked
	 * state when it tries to access a protected resource that's currentlh locked
	 * in another process.
	 * Waiting - threads can be made to wait for other actions or 
	 * Timed Waiting - can call a timed wait method in threads 
	 * Terminated - a thread terminates because either it finishes its 
	 * threads execution naturally, or some unusual or exceptional event
	 * occurs I.E. segmentation fault or unhandled exception.
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		 ExtendsThread et = new ExtendsThread();	 
		 
		 ImplementsRunnable ir = new ImplementsRunnable();
		 Thread isThread = new Thread(ir);
		 
		 Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("In anonymous class implementation");
				for(int i =0; i < 10; i++) {
					System.out.println(" In anon");
				}
			}
		 };
		 
		 Thread anonThread = new Thread(anonRun);

		 Thread exThread = new Thread() {
			//implement run(); here
			 
		 };
		 
		 //LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		 Runnable lambda = () -> {
			
			 System.out.println("in lambda");
			 for(int i = 0; i<10;i++) {
				 System.out.println(i + " in lambda");
			 }
			 
		 };
		 
		 anonThread.setPriority(Thread.MAX_PRIORITY);
		 et.setPriority(Thread.MIN_PRIORITY);
		 Thread lambdaThread = new Thread(lambda);
		 
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