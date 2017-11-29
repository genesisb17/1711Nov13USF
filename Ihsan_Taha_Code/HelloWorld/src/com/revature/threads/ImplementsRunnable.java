package com.revature.threads;

public class ImplementsRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("\nIn ImplementsRunnable Thread");
		for (int i = 0; i < 10; i++)
			System.out.println(i+1 + " In ImplementsRunnable");
	}

}
