package com.revature.threads;

public class ExtendsThread extends Thread {
	public void run() {
		System.out.println("\nIn Extends Thread");
		for (int i=0; i < 10; i++ ) {
			System.out.println(i+1 + " in ExtendsThread");
		}
	}
}
