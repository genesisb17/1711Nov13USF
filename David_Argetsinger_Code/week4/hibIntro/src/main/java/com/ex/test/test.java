package com.ex.test;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.dao.HibDAO;

public class test {
	public static void main(String[] args){
		HibDAO dao=new HibDAO();
		//Student s = new Student("vdefwfv","dfwefwefvrg","qffsdf@email");
		//dao.addStudent(s);
		Product p = new Product();
		p.setPrice(10.00);
		p.setProdName("book");
		dao.addProduct(p);
		//System.out.println(dao.getAllStudents());
		//System.out.println("get by name ");
		//System.out.println(dao.getAllStudentsByName("vdvdv"));
	}

}
