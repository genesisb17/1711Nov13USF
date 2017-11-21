package com.revature.consumerproducer;

import java.util.Iterator;
import java.util.Vector;

public class ConsumerProducer {
	private static Vector<Object> data = new Vector<Object>();
 
	public static void main(String[] args) {
		new Producer().start();
		new Consumer().start();
	}
 
	public static class Consumer extends Thread {
		Consumer() {
			super("Consumer");
		}
 
		@SuppressWarnings("rawtypes")
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Object Consumed");
				} catch (Exception e) {
					e.printStackTrace();
				}
 
				synchronized (data) {
					Iterator it = data.iterator();
					while (it.hasNext())
						it.next();
				}
			}
		}
	}
 
	public static class Producer extends Thread {
		Producer() {
			super("Producer");
		}
 
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Object Produced");
				} catch (Exception e) {
					e.printStackTrace();
				}
				data.add(new Object());
				if (data.size() > 1000)
					data.remove(data.size() - 1);
			}
		}
	}
}


