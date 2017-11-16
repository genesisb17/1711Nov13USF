package com.revature.threads;

import java.util.stream.IntStream;

public class ImplementsRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		IntStream.range(0,  10).forEach(i -> System.out.println(i + " in ImplementsRunnable"));
	}

}
