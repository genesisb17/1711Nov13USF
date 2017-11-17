package com.revature.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	
	static Queue<Integer> q = new LinkedList<>();
	static int maxLength=100;
	
	public static void main(String[] args) {
		Producer prod = new Producer();
		Consumer cons = new Consumer();
		
		Thread producer=new Thread(prod);
		Thread consumer=new Thread(cons);
		
		producer.start();
		consumer.start();
	}
}
