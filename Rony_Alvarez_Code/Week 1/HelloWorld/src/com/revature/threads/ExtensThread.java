package com.revature.threads;

public class ExtensThread extends Thread {

	public void run() {
		System.out.println("In Extends Thread");
		for(int i = 0; i <10; i++) {
			System.out.println(i + "in ExendsThread");
		}
	}
	
}