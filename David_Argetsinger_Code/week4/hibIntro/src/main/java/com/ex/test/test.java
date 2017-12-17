package com.ex.test;

import com.ex.beans.Student;
import com.ex.dao.HibDAO;

public class test {
	public static void main(String[] args){
		HibDAO dao=new HibDAO();
		Student s = new Student("vdefwfv","dfwefwefvrg","qffsdf@email");
		dao.addStudent(s);
		System.out.println(dao.getAllStudents());
		System.out.println("get by name ");
		System.out.println(dao.getAllStudentsByName("vdvdv"));
	}

}
