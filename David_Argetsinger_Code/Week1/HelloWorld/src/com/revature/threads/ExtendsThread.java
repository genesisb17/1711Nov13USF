package com.revature.threads;

public class ExtendsThread extends Thread {
	// 1 of two ways to implement threads
	public void run(){
		System.out.println("in extends thread");
		for (int i = 0 ; i <10 ; i++)
		{
			System.out.println(i+ " in extends thread");
				
		}
	}
}
