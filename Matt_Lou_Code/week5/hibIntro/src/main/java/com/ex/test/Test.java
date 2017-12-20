package com.ex.test;

import java.util.List;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.dao.HibDao;

public class Test {
	public static void main(String[] args) {
		
		HibDao dao = new HibDao();
		Product p = new Product();
		
		p.setPrice(10.00);
		p.setProdName("book");
		dao.addProduct(p);
		
		//Student s = new Student("mat", "lou", "matty@gmail.com");
		//dao.addStudent(s);
		//Student stud = new Student("test", "lou", "yahoo@yahoo.com");
		//dao.addStudent(stud);
//		Student student = new Student();
//		student.setEmail("hi@yahoo.com");
//		student.setFirstname("mattyboy");
//		student.setLastname("lou");
//		dao.addStudent(student);
//		
//		
//		List<Student> list = dao.getAllStudents();
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
		
		
	}
}
