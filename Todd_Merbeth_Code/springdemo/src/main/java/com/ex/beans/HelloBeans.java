package com.ex.beans;

public class HelloBeans {

	private HelloWorld hello;

    public HelloBeans() {
        super();
        System.out.println("In Hellobeans empty constructor");
    }

    public HelloBeans(HelloWorld hello) {
        super();
        System.out.println("In Hellowbeans constructor using fields");
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
