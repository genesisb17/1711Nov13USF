package com.ex.beans;

public class HelloBeans {
	private HelloWorld hello;

	public HelloBeans() {
		System.out.println("in hellobeans empty constructor");
	}
	
	public HelloBeans(HelloWorld hello) {
		super();
		System.out.println("in hellobeans constructor using fields");
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
	public void getHelloWorldInfo() {
		String test = hello.getMessage() + " " + hello.getTest();
		System.out.println(test);
	}
	
	
}
