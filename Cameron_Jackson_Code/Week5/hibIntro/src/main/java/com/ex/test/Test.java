package com.ex.test;


import java.util.List;

import com.ex.beans.Student;
import com.ex.dao.HibDao;

public class Test {
	
	public static void main(String[] args) {
		HibDao dao = new HibDao();
		Student s = new Student("Sally", "Q", "sq@email");
		
		dao.addStudent(s);
		
//		List<Student> students = dao.getAllStudents();
//		for (Student s : students) {
//			System.out.println(s);
//		}
			
//		List<Student> students = dao.getStudentByName("John");
//		for (Student s : students) {
//			System.out.println(s);
//		}
		
//		List<Student> students = dao.queryDemo("John");
//		for (Student s : students) {
//			System.out.println(s);
//		}
	}
}
