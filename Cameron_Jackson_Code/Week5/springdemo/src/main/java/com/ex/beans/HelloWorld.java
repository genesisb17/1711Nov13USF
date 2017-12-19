package com.ex.beans;

/*
 * The objects that form the backbone of your application
 * and are managed by the Spring Inversion of Control (IoC) container are called beans
 * A bean is an object that is instantiated, assembled, and
 * otherwise managed by a Spring Container
 * 
 * Important: properties, lifecycle, methods, scopes
 */
public class HelloWorld {
	
	private String message;
	private String test;
	
	public HelloWorld() {
		System.out.println("in empty constructor");
	}
	
	public HelloWorld(String test) {
		super();
		System.out.println("IN TEST CONSTRUCTOR");
		this.test = test;
	}
	
	public void init() {
		System.out.println("initializing bean");
	}
	
	public void destroy() {
		System.out.println("destorying bean");
	}

	public String getMessage() {
		System.out.println("HELLO " + message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTest() {
		System.out.println("TEST " + test);
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + ", test=" + test + "]";
	}
	
}
