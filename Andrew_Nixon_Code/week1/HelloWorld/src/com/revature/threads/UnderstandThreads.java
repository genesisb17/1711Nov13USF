package com.revature.threads;

public class UnderstandThreads extends Thread {

	
	
	public void run() {
		System.out.println("in Extends Thread");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " in UnderstandThreads");
		}
	}

}
