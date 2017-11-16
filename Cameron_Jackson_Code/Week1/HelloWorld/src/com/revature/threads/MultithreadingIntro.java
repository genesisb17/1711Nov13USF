package com.revature.threads;

public class MultithreadingIntro {

	public static void main(String[] args) {
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
			for (int i = 0; i < 10; ++i) {
				System.out.println(i + " in lambda");
			}
		};
		Thread lambdaThread = new Thread(lambda);
		
		isThread.start();
		et.start();
		anonThread.start();
		lambdaThread.start();
	}

}
