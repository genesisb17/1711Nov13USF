package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloBeans;

public class MainApp 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//configures whole application
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		/*HelloWorld world = (HelloWorld) context.getBean("helloWorld");
		world.getMessage();
		world.getTest();*/
		
		HelloBeans bean = (HelloBeans)context.getBean("beanbean");
	}
}
