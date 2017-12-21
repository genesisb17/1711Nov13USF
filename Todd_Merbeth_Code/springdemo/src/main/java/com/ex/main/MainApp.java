package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloBeans;

public class MainApp {

	/*
	 * Spring DI: Dependency Injection
	 * 
	 * Spring is going to hold our dependencies (our objects) 
	 * 	and inject them where need (apply new object())
	 * 
	 * What is needed for Spring to do DI?
	 * 	 Configure the spring container
	 * 		-by xml
	 * 		-by @s
	 * 		-This example will be using XML 
	 * 
	 * How instantiate a spring container?
	 * 		-beanFactory (old) the parent class, lazy loads beans
	 *		-applicationContext (new) the child class, eagerly loads beans
	 */
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
//		HelloWorld world = (HelloWorld) context.getBean("helloWorld");
//		world.getMessage();
//		world.getTest();
		HelloBeans bean = (HelloBeans) context.getBean("beanbean");
		bean.getHelloWorldInfo();
		bean.getHello().setMessage("We are updating this message");
		bean.getHelloWorldInfo();
	}
}
