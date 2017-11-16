package com.revature.threads;

public class MultithreadingIntro {
	public static void main(String[] args) {
		
//		ExtendsThread et = new ExtendsThread();
//
//		
//		ImplementsRunnable ir = new ImplementsRunnable();
//		Thread isThread = new Thread(ir);
//		isThread.start();
//		et.start();		
	
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("In anon Runnable");
				
				for(int i = 0; i < 10; i++) {
					
					System.out.println(i + " In AnonRunnable");
					
				}
				
			}
			
			
		};
		
		Thread anonyRun = new Thread() {
			
			public void run() {
				
				System.out.println("In anonyRun thread");
				
				for(int i = 0; i < 10; i++) {
					
					System.out.println(i + " In anonyRun thread");
					
				}
			}
			
			
		};
		
		//LAMBDA EXPRESSION TO IMPLEMENT RUNNABLE
		Runnable lambda = () -> {
			System.out.println("in lambda thread");
			for(int i = 0; i < 10; i++) {
				
				System.out.println(i + " In lambda thread");
				
			}
		};
		Thread lambdaThread = new Thread(lambda);
		
		Thread anonThread = new Thread(anonRun);
		anonThread.start();
		anonyRun.start();
		lambdaThread.start();
	}
}
