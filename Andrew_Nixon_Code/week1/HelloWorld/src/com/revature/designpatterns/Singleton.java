package com.revature.designpatterns;

public class Singleton {
	
	int count = 0;
	private static Singleton singleton = new Singleton();
	
	/*
	 * create private constructor preventing any other class from calling and instantiating an 
	 * object of this class
	 */
	private Singleton() {}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void hello() {
		System.out.println("hi sing!");
	}

}
