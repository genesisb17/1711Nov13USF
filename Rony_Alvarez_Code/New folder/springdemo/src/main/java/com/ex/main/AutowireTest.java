package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowire.Employee;

public class AutowireTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Employee e = (Employee) context.getBean("employee");
		e.setName("this is a name");
		e.getName();
		e.getDept();
		
	}

}
