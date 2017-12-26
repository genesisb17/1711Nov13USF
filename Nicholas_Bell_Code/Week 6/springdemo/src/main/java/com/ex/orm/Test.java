package com.ex.orm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		//a different implementation of application context
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ORMDao dao = (ORMDao) ac.getBean("myDao");
		
		//Bear b = new Bear();
		
		Bear b = (Bear) ac.getBean(Bear.class);
		/*b.setName("BooBoo");
		b.setColor("Brown");
		dao.buildABear(b);*/
		
		
		List<Bear> bears = new ArrayList<Bear>();
		bears = dao.getBears();
		for(Bear be : bears) {
			System.out.println(be);
		}
		
	}
	
}
