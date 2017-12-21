package com.ex.beans;

public class HelloBeans {

	private HelloWorld hello;
	
	public HelloBeans() {};
	
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
		System.out.println(hello);
	}

	@Override
	public String toString() {
		return "HelloBeans [hello=" + hello + "]";
	}
	
}
