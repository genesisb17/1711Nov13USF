package com.revature.designpatterns;

public class Singleton {
	
	int count = 0;
	private static Singleton singleton = new Singleton();
	/*
	 * Create a private constructor
	 * to prevent any other class from
	 * calling it and instantiating an object
	 * of the class
	 */

	private Singleton(){}
	
	public static Singleton getInstance(){
		return singleton;
	}
	
	public void hello() {
		System.out.println("Hey singleton!");
	}
}