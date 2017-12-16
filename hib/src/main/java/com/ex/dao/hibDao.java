package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Course;
import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class hibDao
{
	public void addStudent(Student student)
	{
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try
		{
			Transaction tx =(Transaction) session.beginTransaction();
			int scriptid = (Integer) session.save(script);
			student.setId(scriptid);
			student.setTranscript(script);
			
			int studId=(Integer)session.save(student);
			student.setId(studId);
			
			tx.commit();
		}
		finally
		{
			session.close();
		}
	}
	public void addCourse(Course c)
	{
		Session session = ConnectionUtil.getSession();
		try
		{
			Transaction tx =(Transaction) session.beginTransaction();
			session.save(c);
			tx.commit();
		}
		finally
		{
			session.close();
		}
	}
	
	public void addTranscript(Transcript t)
	{
		Session session = ConnectionUtil.getSession();
		try
		{
			Transaction tx =(Transaction) session.beginTransaction();
			session.save(t);
			tx.commit();
		}
		finally
		{
			session.close();
		}
	}
	
	public void addInstructor(Instructor i)
	{
		Session session = ConnectionUtil.getSession();
		try
		{
			Transaction tx =(Transaction) session.beginTransaction();
			session.save(i);
			tx.commit();
		}
		finally
		{
			session.close();
		}
	}

	/*
	 * CRITERIA API
	 * criteria is a simplified api for retrieving entities by composing
	 * Criteria objects.This is a very convenient
	 * approach for functionality like "search" where
	 * there is a variable number of conditions to be 
	 * placed upon the result set
	 */
	public List<Student> getAllStudents()
	{
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		//get list of students
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> getStudentByName(String name)
	{
		String testname = "%"+name+"%";
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.ilike("firstname", testname));
		//get list of students
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	/*
	 * QUERY API
	 * Queries use the Hibernate Query Language - not to be 
	 * confused with SQL! The main difference is that HQL
	 * uses class and property names instead of table and column names, repetively.
	 */
	public List<Student> queryDemo(String name)
	{
		name= "%"+name+"%";
		Session session = ConnectionUtil.getSession();
		String hql ="from Student where lower(firstname) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Student> student = query.list();
		session.close();
		return student;
	}	
}