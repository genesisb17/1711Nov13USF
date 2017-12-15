package com.ex.test;

import com.ex.beans.Student;
import com.ex.dao.HibDao;

public class Test {

	public static void main(String[] args) {

		HibDao dao = new HibDao();
		Student s = new Student();
		s.setEmail("test");
		s.setFirstname("Genesis");
		s.setLastname("is awesome");
		dao.addStudent(s);
	}

}
