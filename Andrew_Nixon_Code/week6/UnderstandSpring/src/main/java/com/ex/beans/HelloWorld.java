package com.ex.beans;

public class HelloWorld {
	
	private String message;
	private String test;
	
	public HelloWorld() {
		System.out.println("in empty constructor");
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
		System.out.println("initializing bean");
	}
	
	public void destroy() {
		System.out.println("destroying bean");
	}
}
