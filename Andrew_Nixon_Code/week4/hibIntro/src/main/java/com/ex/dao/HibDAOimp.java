package com.ex.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Instructor;
import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;


public class HibDAOimp {
	
	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try {
			Transaction tx = 
					(Transaction) session.beginTransaction();
			int scriptId = (Integer) session.save(script);
			script.setId(scriptId);
			student.setTranscript(script);
			
			
			int studId = (Integer) session.save(student);
			student.setId(studId);
			
			tx.commit();
		}
		finally {
			session.close();
		}
		return student;
		
	}
	
	//Criteria API
	//Simplifies api API for retrieving entities by using Criteria objects.
	public List<Student> getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}	
	public List<Student> getStudentsByName(String name){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.ilike("fName", name+"%"));
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	/*
	 * Query API
	 * Use Hibernate Query Language (HQL != SQL)
	 * Difference is HQL uses class and property names instead of table and columna names respectively
	 */
	public List<Student> queryDemo(String name){
		Session session = ConnectionUtil.getSession();
		String hql = " from Student where lower(fName) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Student> students = query.list();
		session.close();
		return students;

	}
	
	public Instructor getInscructorById(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try {
			i = (Instructor) session.get(Instructor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return i;
	}
	
	public Instructor loadInscructorById(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try {
			i = (Instructor) session.load(Instructor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return i;
	}
	
	public Product addProduct(Product product) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = 
					(Transaction) session.beginTransaction();
			session.save(product);
			tx.commit();
		}
		finally {
			session.close();
		}
		return product;
		
	}
}
