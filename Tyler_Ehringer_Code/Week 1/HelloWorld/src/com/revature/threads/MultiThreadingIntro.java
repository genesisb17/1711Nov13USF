package com.revature.threads;

import java.util.stream.IntStream;

public class MultiThreadingIntro {
	
	public static void main(String[] args) {
		
		ExtendsThread et = new ExtendsThread();		
		
		Thread t = new Thread(new ImplementsRunnable());
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				System.out.println("in anon implementation");
				IntStream.range(0, 10).forEach(i -> System.out.println(i + " in anon"));
			}
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("in lambda implementation");
			IntStream.range(0, 10).forEach(i -> System.out.println(i + " in lambda"));
		});
		
		et.start();
		t.start();
		t2.start();
		t3.start();
		
	}
	
}
