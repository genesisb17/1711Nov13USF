package com.ex.aoptest;

import org.springframework.stereotype.Component;

@Component
public class Methods {

	public String test() {
		System.out.println("TEST METHOD NO ARGS");
		return "test";
	}
	
	public void addtest() {
		System.out.println("Waited for 200");
	}
	
	public void hasABCDE() {
		System.out.println("in alphabet method");
	}
	
}
