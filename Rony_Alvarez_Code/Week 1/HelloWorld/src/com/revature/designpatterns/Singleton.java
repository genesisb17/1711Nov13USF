package com.revature.designpatterns;

public class Singleton {

	int count = 0;
	private static Singleton singleton = new Singleton();
		
	/*
	 * Create private constructor 
	 * this prevents any other class from calling it and instantiatinf an object
	 */
	private Singleton() {}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void hello() {
		System.out.println("hey singleton!");
	}
	
	
	
}
