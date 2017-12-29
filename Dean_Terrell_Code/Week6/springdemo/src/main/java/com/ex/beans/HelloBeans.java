package com.ex.beans;

public class HelloBeans {

	private HelloWorld hello;
	
	public HelloBeans() {
		super();
		System.out.println("in HelloBeans empty constructor");
	}

	public HelloBeans(HelloWorld hello) {
		super();
		System.out.println("In HelloBeans constructor using fields!");
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
	public void getHelloWorldInfo () {
		System.out.println(hello.getMessage() + " in new Bean");
	}
}
