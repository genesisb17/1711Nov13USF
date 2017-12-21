package com.ex.beans;
/*
* The objects that form the backbone of your application
* and are managed by the spring IoC container are called beans
* A bean is an object that is instantiated, assembled,
* and otherwise managed by a spring container
*
* important topics: properties, lifecycle, methods, scopes
*/

public class HelloWorld {
    
    private String message;
    private String test;
    
    public HelloWorld() {
        System.out.println("in empty constructor");
    }
    public HelloWorld(String test) {
    	super();
        System.out.println("in test constructor");
        this.test=test;
    }
    
	public String getMessage() {
		System.out.println("MESSAGE:" + message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTest() {
		System.out.println("TEST:" + test);
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
    
    

}