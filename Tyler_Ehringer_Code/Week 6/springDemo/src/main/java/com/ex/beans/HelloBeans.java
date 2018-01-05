package com.ex.beans;

public class HelloBeans {
	
	HelloWorld hello;

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}

	public HelloBeans(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	public HelloBeans() {
		super();
	}
	
	

}
