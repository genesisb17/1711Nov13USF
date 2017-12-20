package com.ex.beans;

/*
 * The objects that form the backbone of your application
 * and are managed by the Spring IoC container are called beans
 * A bean is an object that is instantiated, assembled, 
 * and otherwise managed by a Spring containers
 * 
 * important topics: properties, lifecycle, methods, scopes 
 */

public class HelloWorld {
	private String message;
	private String test;
	
	public HelloWorld() {
		System.out.println("in empty constructor");
	}
	
	

	public HelloWorld(String test) {
		super();
		System.out.println("IN HELLO WORLD TEST CONSTRUCTOR");
		
		this.test = test;
	}



	public String getMessage() {
		System.out.println("HELLO " + message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		System.out.println("TEST: " + test);
		this.test = test;
	}
	
	public void init() {
		System.out.println("initializing bean");
	}
	
	public void destry() {
		System.out.println("destroy");
	}
}



