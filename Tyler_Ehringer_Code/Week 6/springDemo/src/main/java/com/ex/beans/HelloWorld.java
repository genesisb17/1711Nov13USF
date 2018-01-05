package com.ex.beans;

public class HelloWorld {
	
	private String message;
	private String test;
	
	public HelloWorld() {
		System.out.println("in empty constructor");
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	public void init() {
		System.out.println("Initializeing bean");
	}
	
	public void destroy() {
		
		System.out.println("destroying bean");
	}

}
