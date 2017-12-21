package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowire.Employee;

public class AutowireTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e = (Employee) context.getBean("employee");
		Employee e2 = (Employee) context.getBean("employee");
		e.setName("Cam Jackson");
		e.getDept().setName("Tech 1");
		e.getName();
		e.getDept();
		e2.getDept();
	}

}
