package com.ex.test;

import com.ex.beans.Student;
import com.ex.dao.HibDAO;

public class Test {
	
	public static void main(String[] args) {
		HibDAO dao = new HibDAO();
	dao.addStudent(new Student("bob", "vila", "bobvila@gmail.com"));
		
	}

}
