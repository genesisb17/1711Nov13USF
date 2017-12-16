package com.ex.test;

import java.util.List;

import com.ex.beans.Student;
import com.ex.dao.hibDao;

public class Test 
{
	public static void main(String[] args)
	{
		hibDao dao = new hibDao();
		List<Student> s;
		s = dao.getAllStudents();
		//st = dao.getAllStudents();
		for(int i =0;i<s.size();i++)
		{
			System.out.println(s.get(i).getFirstname());
		}
		
	}
}