package com.revature.threads;

public class MultiThreadingIntro {

	/*
	 * States of a thread: new - new thread runnable - when ready to run(may be
	 * running or simply ready to run at any instance) blocked(aka waiting state) -
	 * when a thread is temporarily inactive it is either blocked or waiting. a
	 * thread is in the blocked state when it tries to access a protected section of
	 * code that's currently locked in some other thread waiting- threads can be
	 * made to wait for other actions or: timed waiting - can call a times wait
	 * method in threads terminated - a thread terminates because either it finishes
	 * its thread of execution naturally or because some unusual or exceptional
	 * event occurs. ie segmentation fault or unhandles exception
	 */

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();

		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);

		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("in anon class implementation");
				for (int i = 0; i < 10; i++) {
					System.out.println(i + "in anon");
				}
			}
		};

		Thread anonThread = new Thread(anonRun);

		/*
		 * //LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE 
		 */
		Runnable lambda = () -> {
		  System.out.println("in lambda"); for(int i=0;i<10;i++){
		  System.out.println(i + "in lambda"); }
		};
		 
		  Thread lambdaThread = new Thread(lambda);

		isThread.start();
		et.start();
		anonThread.start();
		lambdaThread.start();

	}
}

