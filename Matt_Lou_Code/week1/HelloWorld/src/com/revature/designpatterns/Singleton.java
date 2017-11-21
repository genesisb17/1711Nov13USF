package com.revature.designpatterns;

public class Singleton {
	int count = 0;
	//this needs to be static along with the getInstance method below
	private static Singleton singleton = new Singleton();
	/*
	 * create a private constructor
	 * this prevents any other class from calling it
	 * and instantiating an obect of the class
	 */
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void hello() {
		System.out.println("Hey singleton!");
	}
	
	
}
