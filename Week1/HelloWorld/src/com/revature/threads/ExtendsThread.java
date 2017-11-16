package com.revature.threads;

public class ExtendsThread extends Thread{
	// 1 out of two ways to implement a thread

	public void run(){
		System.out.println("In Extends Thread");
		for(int i = 0; i < 10; i++){
			System.out.println(i + " in ExtendsThread");
		}
	}
}
