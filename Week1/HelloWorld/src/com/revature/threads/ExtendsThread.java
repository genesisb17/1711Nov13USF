package com.revature.threads;

public class ExtendsThread extends Thread {
	// 1 out of 2 wawys to implement a thread
	
	public void run() {
		
		System.out.println("In extends thread");
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println(i + " In ExtendsThread");
			
		}
	}
}
