package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowired.Employee;

public class AutowireTest 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Employee e =(Employee)context.getBean("employee");
		Employee e2=(Employee)context.getBean("employee");
		
		e.setName("This is a Name");
		e.getName();
		e.getDepart();
	}
}
