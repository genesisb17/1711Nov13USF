package com.ex.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ex.beans.Student;
import com.ex.dao.HibDao;

public class Test {

	public static void main(String[] args) {
		
		HibDao dao = new HibDao();
		
		//Student s = new Student("alison", "arriola", "aarriola@gmail.com");
		//dao.addStudent(s);
		
		/*ArrayList<Student> st = new ArrayList<Student>();
		st.add(s);*/
		//st.add(new Student("jesus", "andrade", "jandrade@gmail.com"));
		//System.out.println((dao.getAllStudents());
		
		List<Student> list = dao.queryDemo("alison");
		
		System.out.println(list.get(0).getFirstname());
		
		
	}
	
}
