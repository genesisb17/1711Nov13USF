package com.ex.test;

import java.util.List;

import com.ex.beans.Student;
import com.ex.dao.HibDAOimp;

public class MainTest {

	public static void main(String[] args) {
		HibDAOimp dao = new HibDAOimp();
		Student s = new Student();
		s.setEmail("test");
		s.setfName("Gen");
		s.setlName("Bon");
		dao.addStudent(s);
	}
}