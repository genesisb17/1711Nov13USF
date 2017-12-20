package com.ex.orm;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("beans.xml");
		ORMDao dao = (ORMDao) ac.getBean("myDao");
		
		
		Bear b = (Bear) ac.getBean(Bear.class);
		b.setName("Pooh");
		b.setColor("yellow");
		dao.buildABear(b);
		
		
		
		ac.close();
	}

}
