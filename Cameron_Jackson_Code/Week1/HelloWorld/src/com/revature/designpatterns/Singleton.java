package com.revature.designpatterns;

public class Singleton {
	int count = 0;
	private static Singleton singleton = new Singleton(); // this is the only instance that will ever exist
	
	/*
	 * create private constructor
	 * this prevents any other class from calling it
	 * and instanctiating an object of the class
	 */
	private Singleton() {}
	
	public static Singleton getInstance() { // return a reference to the only instance that exists
		return singleton;
	}
	
	public void helllo() {
		System.out.println("he singleton!");
	}
}
