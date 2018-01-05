package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowire.Employee;

public class AutoSWireTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee e = (Employee) context.getBean("employee");
		Employee e2 = (Employee) context.getBean("employee");
		e.setName("Robert");
		e2.setName("Geoff");
		e.getDept().setName("Currency Trading");
		e2.getDept().setName("askjfb");
		System.out.println(e.getName());
		System.out.println(e2.getName());
		System.out.println(e.getDept().getName());
		System.out.println(e2.getDept().getName());
	}

}
