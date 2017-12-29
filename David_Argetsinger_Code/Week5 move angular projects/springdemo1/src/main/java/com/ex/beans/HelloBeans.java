package com.ex.beans;

public class HelloBeans {
	private HelloWorld hello;

	
	public HelloBeans() {
		super();
		System.out.println("in hellobeans empty constructor");
		// TODO Auto-generated constructor stub
	}

	public HelloBeans(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	public void getHelloWorldInfo(){
		String message = hello.getMessage()+ " " +hello.getTest();
		System.out.println(message);
		
	}

}
