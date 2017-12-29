package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloBeans;
import com.ex.beans.HelloWorld;

public class MainApp {
/*
 * spring dependency injection 
 * spring is going to hold our depencies our obhects and inject therm where we need 
 * (apply new object())
 * what is needed for it 
 * configure the spring container 
 * -by xml
 * -by @s 
 * -this example will be using XML 
 * 
 * how to instantiate a spring container 
 * -bean factory(old) the parent class , lazy loads beans 
 * -applicationContext(new) the child class, eagerly loads beans 
 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		HelloWorld wolrd = (HelloWorld) context.getBean("helloWorld");
//		wolrd.getMessage();
//		wolrd.getTest();
		HelloBeans bean = (HelloBeans) context.getBean("beanbean");
		bean.getHelloWorldInfo();
		bean.getHello().setMessage("We are in updating this message");
		bean.getHelloWorldInfo();
	}

}
