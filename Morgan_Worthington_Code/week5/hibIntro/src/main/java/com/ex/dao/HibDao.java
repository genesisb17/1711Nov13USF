package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibDao {
	
	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script= new Transcript();
		try {
			Transaction tx = 
					(Transaction) session.beginTransaction();
			int scriptId = (Integer) session.save(script);
			script.setId(scriptId);
			student.setTranscript(script);
			
			
			int studId=(Integer) session.save(student);
			student.setId(studId);

			tx.commit();
		} finally {
			session.close();
		}
		return student;
	}
	
	/*
	 * CRITERIA API
	 * - Criteria is a simplified API for retrieving entities
	 * 	 by composing Criteria objects. This is a very convenient
	 * 	 approach for functionality like "search" where there is 
	 *   a variable number of conditions to be placed upon the
	 *   result set
	 */
	public List<Student> getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> getStudentsByName(String name){
		String testname="%"+name+"%";
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.like("firstname", "test%"));
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	/*
	 * session.get() will always hit the database and return the real object (an object that
	 * represents a row in the db), not a proxy.
	 * If the row isn't found, get() will return null
	 */
	public Instructor getInstructorByID(int id) {
		Session session=ConnectionUtil.getSession();
		Instructor i=null;
		try {
			i=(Instructor) session.get(Instructor.class, id);
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return i;
	}
	/*
	 * session.load() will always return a "proxy"(Hibernate term) without hitting
	 * the database. In Hibernate, a proxy is an object with the given identifier value;
	 * its properties are not initialized yet. It looks like a temporary fake object.
	 * If no row is found, it throws an ObjectNotFoundException,
	 * so only use this if you're sure the object exists
	 */
	public Instructor loadInstructorById(int id) {
		Session session=ConnectionUtil.getSession();
		Instructor i=null;
		try {
			i=(Instructor) session.load(Instructor.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return i;
	}
	
	/*
	 * QUERY API
	 * Queries use Hibernate Query Language - not to be
	 * confused with SQL! The main difference is that HQL
	 * uses class and property names instead of table and
	 * column names, respectively
	 */
	public List<Student> queryDemo(String name){
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("param", name);
		List<Student> students = query.list();
		session.close();
		return students;
	}
	
	//calling an HQL named query example
	public List<Instructor> getNamesLike(String like){
		Session session=ConnectionUtil.getSession();
		Query query=session.getNamedQuery("findInstructorbyNameHQL").setString("name", like);
		List<Instructor> i=query.list();
		return i;
	}
	
	//calling native SQL named query. same syntax
	public Instructor getInstructorById(int id) {
		Session session = ConnectionUtil.getSession();
		Query query = session.getNamedQuery("findInstructorByIdSQL").setInteger("id", id);
		Instructor i=(Instructor) query.list().get(0);
		return i;
	}
	
}
