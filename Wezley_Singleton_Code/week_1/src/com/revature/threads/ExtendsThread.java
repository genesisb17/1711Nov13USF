package com.revature.threads;

public class ExtendsThread extends Thread {
	
	/*
	 *  The first of two ways to implement a thread
	 */

	public void run() {
		System.out.println("In ExtendsThread");
		
		for(int i = 0; i < 10000; i++) {
			if (i % 1000 == 0) {	System.out.println(i + " in ExtendsThread"); }
		}
		
	}
}
