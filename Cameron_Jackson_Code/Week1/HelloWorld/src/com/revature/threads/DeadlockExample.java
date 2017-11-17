package com.revature.threads;

import java.util.Random;

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
		
		// Start threads
		// ** They have to be stopped manually, there's no termination condition
		producerThread.start();
		consumerThread.start();
	}
	
	/*
	 * Producer()
	 * will use the Singleton object to produce an item and add it 
	 * to list
	 */
	static void Producer(Singleton s) {
		Random rand = new Random();
		Integer item;
		synchronized(s) { // synchronize the item object to promote thread safety
			while (true) {
				if (s.getCount() == s.getMaxCount()) { // getCount and getMaxCount return primitive int
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				item = rand.nextInt(100) + 1; // generate random number from 1 to 100
				s.produceItem(item);
				System.out.println("Produced: " + item + ", Items: " + s.getCount());
				if (s.getCount() == 1) s.notify();
			}
		}
	}
	
	/*
	 * Consumer()
	 * will use the Singleton object to consume an item and remove it 
	 * from the list
	 */
	static void Consumer(Singleton s) {
		synchronized(s) {
			while (true) {
				if (s.getCount() == 0) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Consumed: " + s.consumeItem());
				if (s.getCount() < s.getMaxCount()) s.notify();
			}
		}
	}
}

