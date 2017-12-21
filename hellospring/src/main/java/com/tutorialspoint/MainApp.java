package com.tutorialspoint;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp 
{
	public static void main(String[] args) {
		   ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		   
		   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		   helloWorld.setMessage1("Hello World!");
		   helloWorld.getMessage2();
		}
}