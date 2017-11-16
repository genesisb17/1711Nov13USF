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
		
		Runnable anonRun = new Runnable() { // inner class to extend runnable
			@Override
			public void run() {
				System.out.println("In anonymous class implementation");
				for (int i = 0; i < 10; ++i) {
					System.out.println(i + " In anonymous class implementation");
				}
			}
		};
		Thread anonThread = new Thread(anonRun);
		
		isThread.start();
		et.start();
		anonThread.start();
	}

}
