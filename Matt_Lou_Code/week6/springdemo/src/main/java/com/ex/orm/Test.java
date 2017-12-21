package com.ex.orm;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ORMDao dao = (ORMDao) ac.getBean("myDao");
		
		//Bear b = new Bear();
		/*
		 * note that the purpose of beans is to avoid the new keyword! 
		 */
		Bear b = (Bear) ac.getBean(Bear.class);
		b.setName("test");
		b.setColor("red");
		dao.buildABear(b);
		
		//dao.getBears();

	}

}
