package com.ex.aoptest;

import org.springframework.stereotype.Component;

@Component
public class Methods {
	public String test(){
		System.out.println("test method no args ");
		return "test";
	}
	public void addtest() throws InterruptedException{
		//wait(200);
		System.out.println("waitfed for 200");
		
	}
	public void hasABCDE(){
		System.out.println("ub alphabet method");
		
	}
}
