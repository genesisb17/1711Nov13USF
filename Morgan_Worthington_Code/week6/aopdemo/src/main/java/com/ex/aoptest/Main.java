package com.ex.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		
		Methods test=(Methods) context.getBean("methods");

		test.hasABCDE();

		try {
			test.addTest();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
