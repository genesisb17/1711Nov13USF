package com.ex.orm;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ORMDao dao = (ORMDao) ac.getBean("myDao");
		Bear b = (Bear) ac.getBean(Bear.class);
		b.setName("Smokey");
		b.setColor("Brown");
		
		dao.buildABear(b);
		List<Bear> bears = dao.getBears();
		System.out.println(bears.get(0));
	}
}
