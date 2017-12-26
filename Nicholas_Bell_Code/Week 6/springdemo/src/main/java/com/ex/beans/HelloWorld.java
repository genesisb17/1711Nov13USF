package com.ex.beans;
/*
 * The objects that form the back bone of your application and are managed by 
 * the Spring IOC container are called beans.
 * a Bean is an object that is instantiated, assembled, and otherwise managed
 * by a Spring Container.
 * 
 * Important topics: properties, lifecycle, methods, scopes
 */
public class HelloWorld {
	private String message;
	private String test;
	
	public HelloWorld() {
		System.out.println("in empty constructor");
		
	}

	public HelloWorld(String test) {
		super();
		System.out.println("in helloworld field constructor");
		this.test = test;
	}
	
	public String getMessage() {
		System.out.println("MESSAGE: " + message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTest() {
		System.out.println("TEST:" + test);
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	public void init() {
		System.out.println("initialization bean");
	}
	
	public void destroy() {
		System.out.println("destroy");
	}
}
