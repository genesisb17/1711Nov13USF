package com.ex.orm;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("beans.xml");
		ORMDao dao = (ORMDao) ac.getBean("myDao");
		Bear b = (Bear) ac.getBean(Bear.class);
		b.setColor("black");
		b.setName("Too Easy");
		dao.buildABear(b);
		
//		ArrayList<Bear> bears = (ArrayList<Bear>) dao.getBearsCriteria();
//		for (Bear b: bears) {
//			System.out.println(b);
//		}
	}
}
