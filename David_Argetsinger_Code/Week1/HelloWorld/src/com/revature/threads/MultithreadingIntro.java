package com.revature.threads;

public class MultithreadingIntro {
	/*
	 * states of thread: 
	 * new - new thread
	 * runnable - when ready to run (may be running or ready to run
	 * blocked -(waitingstate) when a thread is temp inactive- either blocked or waiting
	 * 	tthread is in blocked state when attempting to access a protected section of code 
	 * 	that currently locked in some other thread  
	 * waiting  - threads can be made to wait for other actions or:
	 * timed waiting  - can call a timed wait method in threads 
	 * terminated - a thread terminates becomes because exit or finished  or unusual/ exceptional
	 * 	event occurs i.e seg fault , unhandled exception 
	 */

	public static void main(String[] args) throws InterruptedException {
		ExtendsThread et = new ExtendsThread();
		
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread= new Thread(ir);
		
		
		//third way, well really 2.5 (innerclass) anon 
		Runnable anonRun= new Runnable(){
			@Override
			public void run() {
				System.out.println("in anon class implementation thread");
				for (int i = 0 ; i <10 ; i++)
				{
					System.out.println(i+ " in anon");
						
				}	
			}
		};
		Thread anonThread= new Thread(anonRun);
		Thread exThread= new Thread(){
		//implement run here  2.7
		};
		
		
		//lambduh expression to implement runnable 
		Runnable lambda= () -> {
			System.out.println("In labmbadam");
			for (int i = 0 ; i <10 ; i++)
			{
				System.out.println(i+ " in in lambanana");
					
			}	
		
		};
		Thread lambdaThread= new Thread(lambda);
		
		anonThread.setPriority(Thread.MAX_PRIORITY);
		et.setPriority(Thread.MIN_PRIORITY);
		System.out.println("STATE: "+ et.getState());
		isThread.start();
		et.start(); // has it's own thread start 
		//et.sleep(10);
		System.out.println("STATE: "+ et.getState());
		//et.sleep(100);
		anonThread.start();// anon thread start 
		lambdaThread.start();
		System.out.println("STATE: "+ et.getState());
		
	}

}
