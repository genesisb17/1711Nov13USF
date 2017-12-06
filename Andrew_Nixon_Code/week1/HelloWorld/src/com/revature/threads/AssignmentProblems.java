package com.revature.threads;

import java.util.LinkedList;

public class AssignmentProblems {

	/*
	 * DEADLOCK Problem Two Treads are waiting on one another to complete to
	 * continue. Solution
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		/*
		 * DumbWaiter chaz = new DumbWaiter("Chaz"); DumbWaiter trent = new
		 * DumbWaiter("Trent"); new Thread(new Runnable() { public void run() {
		 * chaz.hi(trent); } }).start(); new Thread(new Runnable() { public void run() {
		 * trent.hi(chaz); } }).start();*
		 */

		// PRODUCER CONSUMER
		ProducerConsumer prodCon = new ProducerConsumer();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					prodCon.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					prodCon.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
	}
	
}

