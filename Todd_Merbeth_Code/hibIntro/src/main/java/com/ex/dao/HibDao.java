package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibDao {

	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
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
	
	/*
	 * CRITERIA API
	 * - Criteria is a simplified API for retrieving entities
	 * 	by composing Criteria objects. This is a very convenient 
	 *  approach for functionality like "search" where there
	 *  is a variable number of conditions to be placed upon
	 *  the rest
	 */
	public List<Student> getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> getStudentsByName(String name){
		String testname = ("%"+name+"%").toLowerCase();
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.like("firstname", testname));
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	/*
	 * QUERY API
	 * Queries use the Hibernate Query Language (HQL) - not to be
	 * confused with SQL! The main difference is that HQL uses 
	 * class and property names instead of table and
	 * column names, respectively.
	 */
	public List<Student> queryDemo(String name){
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :param";
		Query query = session.createQuery(hql);
		query.setParameter("param", name);
		List<Student> students = query.list();
		session.close();
		return students;
		
	}
}