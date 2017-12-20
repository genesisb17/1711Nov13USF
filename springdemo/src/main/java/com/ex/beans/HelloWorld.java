package com.ex.beans;

/*
 * The objects that form the backbone of your application
 * and are managed by the Spring IoC container are called
 * beans. A beans is an object that is instantiated, assembled,
 * and otherwise managed by a spring containers
 * 
 * important topics: properties, lifecycle, methods, scopes
 * */

public class HelloWorld 
{
	private String message;
	private String test;
	public HelloWorld()
	{
		System.out.println("test");
	}
	
	public HelloWorld(String test)
	{
		super();
		System.out.println(test);
		this.test=test;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) 
	{
		System.out.println("HELLO "+message);
		this.message = message;
	}
	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}
	public void init()
	{
		System.out.println("initializing bean");
	}
	
	public void destroy()
	{
		System.out.println("destroy");
	}
}
