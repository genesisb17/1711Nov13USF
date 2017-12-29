package com.ex.beans;
/*
 * the objects that form the backborn of youe application are managed by 
 * the spring IOC( inverseion of control) contain are called beans 
 * a bean is an object that is instantiated assembed and managed by sprign contaienr 
 * 
 * important topic: properties lifecycle methods scope 
 */
public class HelloWorld {
	private String message;
	private String test;
	public HelloWorld(){
		System.out.println(" in empty constructor ");
	}
	
	public HelloWorld(String test) {
		super();
		System.out.println(" IN TEST CONSTRUCTOR ");
		this.test = test;
	}

	public String getMessage() {
		System.out.println("hello"+ message);
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTest() {
		System.out.println("TEST: " + test );
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public void init(){
		System.out.println("initializing bean");
	}
	public void destroy(){
		System.out.println("destroy");
	}
	
}
