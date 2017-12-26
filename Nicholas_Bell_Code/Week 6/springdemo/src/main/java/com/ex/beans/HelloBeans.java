package com.ex.beans;

public class HelloBeans {

	private HelloWorld hi;

	public HelloWorld getHi() {
		return hi;
	}

	public void setHi(HelloWorld hi) {
		System.out.println("in fields constructor");
		this.hi = hi;
	}
	
	public HelloBeans() {
		super();
		System.out.println("in hello beans empty constructor");
	}
	
	public void getHelloWorldInfo() {
		String test = hi.getMessage() + hi.getTest();
		System.out.println(test);
	}
	
}
