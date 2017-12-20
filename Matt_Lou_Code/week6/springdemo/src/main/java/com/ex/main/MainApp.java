package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloWorld;

public class MainApp {
	/*
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		
		// the parameter passed "helloWorld" is whatever we passed in the xml file
		HelloWorld world = (HelloWorld) context.getBean("helloWorld");
		world.getMessage();
		world.getTest();
	}
}
