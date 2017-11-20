package com.revature.designpatterns;

public class Singleton {
	int count = 0;
	private static Singleton singleton = new Singleton();
	
	
	
	private Singleton() {}
	
	public static Singleton getInstance() {

		return singleton;
		
	}

	public void hello() {
		System.out.println("helo!");
	}
}