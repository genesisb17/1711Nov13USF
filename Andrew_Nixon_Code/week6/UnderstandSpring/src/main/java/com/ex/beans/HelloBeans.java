package com.ex.beans;

public class HelloBeans {
	
	private HelloWorld hello;
	
	public HelloBeans() {
		super();
		System.out.println("in hellobeans empty");
	}

	public HelloBeans(HelloWorld hello) {
		super();
		this.hello = hello;
		System.out.println("in hellobeans fields");

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
