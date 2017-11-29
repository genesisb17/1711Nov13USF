package com.revature.problems;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ProConProblems {
	
	static void createDeadlock() {
		
		String s1 = "Resource 1", s2 = "Resource 2";
		
		Thread t1 = new Thread(() -> {
			System.out.println("t1 will now request s1");
			synchronized(s1) {
				System.out.println("t1 owns s1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1 will now request s2");
				synchronized(s2) {
					System.out.println("t1 owns s2");
				}
			}
		});
		Thread t2 = new Thread(() -> {
			System.out.println("t2 will now request s2");
			synchronized(s2) {
				System.out.println("t2 owns s2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2 will now request s1");
				synchronized(s1) {
					System.out.println("t2 owns s1");
				}
			}
		});
		
		t1.start();
		t2.start();
	}
	
	public static String randomString(int minSize, int maxSize) {
		String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ";
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		IntStream.rangeClosed(0, r.nextInt(maxSize - minSize) + minSize)
			.map(i -> charset.charAt(r.nextInt(charset.length())))
			.forEach(i -> sb.append((char)i));
		return sb.toString();
	}
	
	
	public static void producerConsumer() {
		LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>(32);
		
		Thread producer = new Thread(() -> {
			IntStream.range(0, 100).forEach(i -> {
				try {
					lbq.put(randomString(5, 15));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});
		Thread consumer = new Thread(() -> {
			IntStream.range(0,  100).forEach(i -> {
				try {
					System.out.println(lbq.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});
		
		producer.start();
		consumer.start();	
	}

	public static void main(String[] args) {
		producerConsumer();
		
	}
	
}
