package com.ex.beans;

public class HelloBeans 
{
	private HelloWorld hello;
	public HelloBeans()
	{
		super();
		System.out.println("in hellobeans empty constructor");
	}
	/**
	 * @return the hello
	 */
	public HelloWorld getHello() {
		return hello;
	}
	/**
	 * @param hello the hello to set
	 */
/*	public void setHello(HelloWorld hello) {
		
		this.hello = hello;
	}*/
	public HelloBeans(HelloWorld hello) 
	{
		super();
		this.hello = hello;
	}
	public void getHelloWorldInfo()
	{
		String test=hello.getMessage()+" "+hello.getTest();
		System.out.println(test);
	}
}
