package com.ex.test;

import java.util.ArrayList;

import com.ex.beans.Student;
import com.ex.dao.HibDao;

public class Main {

	public static void main(String[] args) {
		
		HibDao dao = new HibDao();
		
/*		// Add Student
		Student s = new Student("Yosuf", "ElSaadany", "yosuf@email");
		dao.addStudent(s);
		
		// Get all Students
		ArrayList<Student> s1 = new ArrayList<Student>();
		s1 = (ArrayList<Student>) dao.getAllStudents();
		System.out.println(s1.toString());*/
		
		// Get Student by name
		/*ArrayList<Student> s2 = new ArrayList<Student>();
		s2 = (ArrayList<Student>) dao.queryDemo("gen");	
		System.out.println(s2.toString());*/
		
		Student s = new Student("Joe", "Joeee", "joe@email");
		dao.addStudent(s);
		
		
	}

}
