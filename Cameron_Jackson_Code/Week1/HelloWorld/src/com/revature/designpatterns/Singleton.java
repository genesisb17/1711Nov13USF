package com.revature.designpatterns;

import java.util.Deque;

public class Singleton {
	private static int max_count; // max number of items
	private static Deque<Integer> stack; // just something to threads to manipulate
	private static Singleton singleton = new Singleton(); // this is the only instance that will ever exist
	
	/*
	 * create private constructor
	 * this prevents any other class from calling it
	 * and instantiating an object of the class
	 */
	private Singleton() {
		max_count = 50;
	}
	
	private Singleton(int max) {
		max_count = max;
	}
	
	public static Singleton getInstance() { // return a reference to the only instance that exists
		return singleton;
	}
	
	// not used in DeadlockExample class
	public void hello() {
		System.out.println("he singleton!");
	}
	
	public void produceItem(Integer item) { // add "item" to list
		stack.push(item);
	}
	
	public Integer consumeItem() { // remove "item from list
		return stack.pop();
	}
	
	public int getCount() {
		return stack.size();
	}
}
