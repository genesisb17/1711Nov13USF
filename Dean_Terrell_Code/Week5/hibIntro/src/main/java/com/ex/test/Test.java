package com.ex.test;

import java.util.ArrayList;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.dao.hipDao;

public class Test {
	
	public static void main(String[] args) {
		hipDao dao = new hipDao();
		Student s = new Student("New stuff", "MANG", "sdadfae@blub.com");
		
		dao.addStudent(s);
		ArrayList<Student> students = (ArrayList<Student>) dao.queryDemo("i");
		System.out.println(students);
		
		Product p = new Product();
		p.setPrice(30.50);
		dao.addProduct(p);
	}
}