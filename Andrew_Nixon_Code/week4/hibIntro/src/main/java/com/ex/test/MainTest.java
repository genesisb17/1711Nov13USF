package com.ex.test;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.dao.HibDAOimp;

public class MainTest {

	public static void main(String[] args) {
		HibDAOimp dao = new HibDAOimp();
//		Student s = new Student();
//		s.setEmail("test");
//		s.setfName("Gen");
//		s.setlName("Bon");
//		dao.addStudent(s);
		
		Product p = new Product();
		p.setPrice(10);
		p.setProdName("Book");
		dao.addProduct(p);
		
	}
}