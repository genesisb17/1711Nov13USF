package com.revature.threads;

public class ImplementsRunnable implements Runnable{
	//2 of 2 ways to make a thread
	//runnable has 1 abs method (functional)
	// if a concrete class implements a functional interface need to define methods
	@Override
	public void run() {
		System.out.println("in extends thread");
		for (int i = 0 ; i <10 ; i++)
		{
			System.out.println(i+ " in extends thread");
				
		}
	}
	

}
