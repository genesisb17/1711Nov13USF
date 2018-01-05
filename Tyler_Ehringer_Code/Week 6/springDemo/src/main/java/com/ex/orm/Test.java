package com.ex.orm;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ORMDao dao = (ORMDao) ac.getBean("myDao");
		
		
		
		Bear bear = (Bear) ac.getBean(Bear.class);
		bear.setColor("Blue");
		bear.setName("Billy");
		dao.buildABear(bear);
		
		System.out.println(dao.getBears());
		
		
	}

}
