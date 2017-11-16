package com.revature.threads;

import java.util.stream.IntStream;

public class ExtendsThread extends Thread {

	public void run() {
		System.out.println("In ExtendsThread");
		IntStream.range(0,  10).forEach(i -> System.out.println(i + " in ExtendsThread"));
	}
	
}
