package com.ex.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.orm.Bear;
import com.ex.orm.ormDAO;

public class ORMTest {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ormDAO dao = (ormDAO) ac.getBean("myDao");
		
//		Bear b1 = (Bear) ac.getBean(Bear.class);
//		Bear b2 = (Bear) ac.getBean(Bear.class);
//		Bear b3 = (Bear) ac.getBean(Bear.class);
//		Bear b4 = (Bear) ac.getBean(Bear.class);
//		b1.setName("Smokey");
//		b1.setColor("Brown");
//		b2.setName("Yogi");
//		b2.setColor("Light Brown");
//		b3.setName("Coke");
//		b3.setColor("White");
//		b4.setName("Ruxpin");
//		b4.setColor("Tan");
		
		List<Bear> bl = dao.getBears();
		for (Bear b: bl) {
			System.out.println(b.toString());
		}


	}

	
}
