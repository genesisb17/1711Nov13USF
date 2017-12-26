package com.ex.test;

import java.util.List;

import com.ex.DAO.hibDAO;
import com.ex.beans.Product;
import com.ex.beans.Student;

public class Test {

	
	public static void main(String[] args) {
		hibDAO dao = new hibDAO();
		Product p = new Product();
		p.setPrice(10.00);
		p.setProdName("Quark");
		dao.addProduct(p);
	}
	
/*
	public static void main(String[] args) {
		hibDAO dao = new hibDAO();
		Student s = new Student("guy", "dude", "gd@gmail.com");
		//List<Student> roster = dao.queryDemo("NIC");
		s = dao.addStudent(s);
		//for(Student body : roster) {
		//	System.out.println(body);
		
		//}
		System.out.println(s);
		
	}*/
}
