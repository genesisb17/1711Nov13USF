package com.ex.aoptest;

import org.springframework.stereotype.Component;

@Component
public class Methods {

	public String test() {
		System.out.println("TEST METHOD NO ARGS");
		return "test";
	}
	
	public void addtest() {
//		try {
//			wait(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("waited for 200");
	}
	
	public void hasABCDE() {
		System.out.println("in aphabet method");
	}
}
