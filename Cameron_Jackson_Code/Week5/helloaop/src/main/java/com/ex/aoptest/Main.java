package com.ex.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Methods m = (Methods) context.getBean(Methods.class);
	
		m.hasABCDE();
		m.test();
		m.addtest();
	}

}
