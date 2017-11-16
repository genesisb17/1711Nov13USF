package com.revature.designPatterns;

public class Singleton {

	private int count = 0;
	private static Singleton s = new Singleton();
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		return s;
	}
	
	public void hello() {
		System.out.println("Hello World!");
	}
}
