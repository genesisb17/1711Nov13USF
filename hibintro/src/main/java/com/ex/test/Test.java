package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ex.beans.Student;
import com.ex.dao.HibDao;
import com.ex.util.ConnectionUtil;

public class Test {

	public static void main(String[] args) {
		
		HibDao dao = new HibDao();
//		Student s = new Student("yosuf", "a", "ya@email");
//		dao.addStudent(s);
		ArrayList<Student> x = new ArrayList<>();
		ArrayList<Student> y = new ArrayList<>();
		ArrayList<Student> z = new ArrayList<>();
		x = (ArrayList<Student>) dao.getAllStudents();

		
		for(Student res : x) {
			
			System.out.println(res.toString());
			
		}
		
		y = (ArrayList<Student>) dao.getStudentsByName("Yos");
		
		z = (ArrayList<Student>) dao.queryDemo("gen");
		
		for(Student ult : y) {
			System.out.println(ult.toString());
			System.out.println("This is getStudentsByName");
		}
		
		for(Student qq : z) {
			System.out.println(qq.toString());
			System.out.println("This is queryDemo");
		}
		
	}
}
