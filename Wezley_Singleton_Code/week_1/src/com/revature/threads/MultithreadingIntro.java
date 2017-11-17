package com.revature.threads;

public class MultithreadingIntro {
	
	/*
	 *  States of a thread:
	 *  	- New (new thread)
	 *  
	 *  	- Runnable (running or ready to run)
	 *  
	 *  	- Blocked (waiting state when a thread is temporarily inactive; typically when the thread 
	 *  		tries to access a protected section of code)
	 *  
	 *  	- Waiting (waiting state when a thread is temporarily inactive and waiting for an action)
	 *  
	 *  	- Timed Waiting (can call a timed wait method in threads)
	 *  
	 *  	- Terminated (the thread terminates because it either finishes its thread of execution
	 *  		naturally or because some unusual or exceptional event occurs, i.e. segmentation fault
	 *  		or unhandled exception)
	 */
	public static void main(String[] args) {
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		isThread.start();
		et.start();
		
		// another anonymous inner class!
		Runnable anonRun = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("In anonymous class implementation");
				
				for(int i = 0; i < 10; i++) {
					System.out.println(i + " in anon");
				}
			}
			
		};
		
		Thread anonThread = new Thread(anonRun);
		
		// you can use an anonymous inner class to override the run() implementation of Thread class as well
		Thread exThread = new Thread() {
			// override run() implementation here
		};
		
		/*
		 *  lambda expressions are used with functional interfaces (interfaces with only one abstract method)
		 *  since there is only one abstract method, key do not need to used the various keywords normally 
		 *  used by an anonymous inner class, it is implicit.
		 *  
		 *  Reference for lambda vs anonymous inner class: 
		 *  	https://stackoverflow.com/questions/22637900/java8-lambdas-vs-anonymous-classes
		 */
		Runnable lambda = () -> {
			System.out.println("in lambda");
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
		lambdaThread.start();
		anonThread.start();
		
	}

}
