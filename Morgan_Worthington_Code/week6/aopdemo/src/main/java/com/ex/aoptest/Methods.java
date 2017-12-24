package com.ex.aoptest;

public class Methods {
	
	public String test() {
		System.out.println("TEST METHOD NO ARGS");
		return "test";
	}
	
	public void addTest() throws InterruptedException {
		wait(200);
		System.out.println("waited for 200");
	}
	
	public void hasABCDE() {
		System.out.println("in alphabet method");
	}
}
