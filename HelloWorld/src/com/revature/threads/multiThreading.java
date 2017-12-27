package com.revature.threads;

public class multiThreading 
{
	/*
	 * states of a thread 
	 * new - new thread
	 * runnable - when ready to run may be running or simply ready to run at any instance
	 * blocked - aka waiting state - when a thread is temporarily inactive it is either blocked or waiting
	 * A thread is in in the blocked state when it tries to access a protected section of code that's currently
	 * locked in some other thread
	 * waiting - threads can be made to wait for other actions or
	 * Timed Waiting - can call a timed wait method in threads
	 * Terminated -  a thread terminates because either it finishes its thread of execution naturally
	 * or because some unusual or exceptional event occurs ie segmentation fault or unhandled exception.
	 */
	public static void main(String[] args)
	{
		ExtendThread et = new ExtendThread();

		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);

		Runnable anonRun = new Runnable(){
			@Override
			public void run()
			{
				System.out.println("In anonymous class");
				for(int i = 0;i<10;i++)
				{
					System.out.println(i+"in anon");
				}
			}
		};
		Thread anonThread = new Thread(anonRun);

		Runnable lambda= () -> {
			
			System.out.print("in lambda");
			for(int i=0;i<10;i++)
			{
				System.out.println(i+"in lambda");
			}
		};
		Thread lambdaThead = new Thread(lambda);
		
		System.out.println("State: "+et.getState());
		isThread.start();
		
		anonThread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("State: "+et.getState());
		et.start();
		//et.sleep(1000);
		et.setPriority(Thread.MIN_PRIORITY);
		System.out.println("State: "+et.getState());
		anonThread.start();
		//lambdaThread.start();
		System.out.println("State: "+et.getState());
	}
	//lambda is a functional interface
}