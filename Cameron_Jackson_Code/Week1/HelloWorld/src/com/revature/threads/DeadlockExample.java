package com.revature.threads;

import com.revature.designpatterns.Singleton;

public class DeadlockExample {
	/*
	 * Item managed will be a Singleton object
	 * since only one Singleton object can exist, 
	 * multiple threads accessing object could have 
	 * deadlock issues
	 */
	public static void main(String[] args) {
		Singleton itemHolder = Singleton.getInstance();
		// Anonymous class for Producer to implement run
		Thread producerThread = new Thread(() -> Producer(itemHolder));
		
		// Anonymous class for Consumer to implement run
		Thread consumerThread = new Thread(() -> Consumer(itemHolder));
	}
	
	/*
	 * Producer()
	 * will use the Singleton object to produce an item and add it 
	 * to list
	 */
	static void Producer(Singleton s) {
		
	}
	
	/*
	 * Consumer()
	 * will use the Singleton object to consume an item and remvoe it 
	 * from the list
	 */
	static void Consumer(Singleton s) {
		
	}
}

