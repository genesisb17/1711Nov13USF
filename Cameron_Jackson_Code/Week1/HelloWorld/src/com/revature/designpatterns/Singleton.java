package com.revature.designpatterns;

import java.util.Deque;

public class Singleton {
	private static int count = 0; // number of "items"
	private static Deque<Integer> stack; // just something to threads to manipulate
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
	
	public void hello() {
		System.out.println("he singleton!");
	}
	
	public void produceItem(Integer item) { // add "item" to list
		++count;
		stack.push(item);
	}
	
	public Integer consumeItem() {
		--count;
		return stack.pop();
	}
}
