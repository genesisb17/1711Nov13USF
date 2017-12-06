package com.revature.threads;

import java.util.LinkedList;

public class ProducerConsumer {

	LinkedList<Integer> list = new LinkedList<Integer>();
	int maxSize = 5;
	
	public void produce() throws InterruptedException {
		int count = 0;
		while (true) {
			synchronized(this) {
				while (list.size() == maxSize) {
					wait();
				}
				
				System.out.println("count " + count);
				count++;
				list.add(count);
				notify();
				Thread.sleep(1000);
			}
		}		
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (this) {
				while (list.size() == 0) {
					wait();
				}
				int toBeConsumed = list.removeFirst();
				
				System.out.println("consumed " + toBeConsumed);
				
			//	notify();
				
				Thread.sleep(1000);
			}
		}
	}
	
}
