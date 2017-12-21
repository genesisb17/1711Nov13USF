package com.ex.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.dao.HibDao;
import com.ex.util.ConnectionUtil;

public class Test {
	public static void main(String[] args) {
//		ArrayList<Student> s=new ArrayList<>();
		HibDao dao = new HibDao();
//		Student s = new Student();
//		s.setFirstname("John");
//		s.setLastname("Bob");
//		s.setEmail("John.Bob.000@gmail.com");
//		dao.addStudent(s);
//		//s=(ArrayList<Student>) dao.getStudentsByName("Marshall");
//		s=(ArrayList<Student>) dao.queryDemo("Marshall");
//		System.out.println(s);
		Product p=new Product();
		p.setPrice(10.00);
		p.setProdName("Book");
		dao.addProduct(p);
	}
	
	
}
