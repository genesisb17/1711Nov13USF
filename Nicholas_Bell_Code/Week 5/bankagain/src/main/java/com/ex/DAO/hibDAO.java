package com.ex.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class hibDAO {
	
	public Student addStudent(Student stu) {
		Session session = ConnectionUtil.getSession();
		Transcript tScript = new Transcript();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			
			int tsID = (Integer) session.save(tScript);
			stu.setTranscript(tScript);
			tScript.setId(tsID);
			int stuID = (Integer) session.save(stu);
			stu.setId(stuID);
			
			session.save(stu);
			tx.commit();
		}
		finally {
			session.close();
		}
		return stu;
	}
	
	//CRITERIA API
	/*
	 * a simplified api for retrieving entities by composing
	 * Criteria objects. this VERY convenient approach for functionality like
	 * "search" where there is a variable number of conditions to be placed upon the result set
	 */
	public List<Student> getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria crit = session.createCriteria(Student.class);
		List<Student> stus = crit.list();
		session.close();
		return stus;
	}
	
	public List<Student> getStudentsByName(String name){
		String testname = "%"+name+"%";
		Session session = ConnectionUtil.getSession();
		Criteria crit = session.createCriteria(Student.class).add(Restrictions.like("firstname", testname));
		List<Student> stus = crit.list();
		session.close();
		return stus;
	}
	
	/*
	 * QUERY API
	 * Queries use the Hibernate Query Language - not to be 
	 * confuse with sql. the main diff is that hql
	 * uses class and property names instead of table and 
	 * column names, respecivelt\y
	 */
	public List<Student> queryDemo(String name){
		String testname = ("%"+name+"%").toLowerCase();
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :param";
		org.hibernate.Query q = session.createQuery(hql);
		q.setParameter("param", testname);
		List<Student> students = q.list();
		session.close();
		return students;
	}
	
	/*
	 * session.load() will always return a "proxy" (Hibernate term)
	 * without hitting the database. In Hibernate, a proxy is an object with the given
	 * identifier value.
	 */
	
	public void addProduct(Product p) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			
			session.save(p);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	
	

}
