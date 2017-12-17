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



public class HibDAO {
	public Student addStudent(Student student){
		Session session= ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			int scriptId=(Integer)session.save(script);
			script.setId(scriptId);
			student.setTranscript(script);
			
			int studID=(Integer)session.save(student);
			student.setId(studID);
			
				tx.commit();

			}
			finally{
				session.close();
			}
		return student;
		
	}
	//criteria API 
	//criteria is a simplified api for retiving entiried bty compositn criteira objects
	//this is verst convient appoach for functionalityu liek 
	//seach where there is a vaiable number of contions to be placed upon the result set 
	public List<Student>getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student>students=criteria.list();
		session.close();
		return students;
		
	}
	public List<Student>getAllStudentsByName(String name){
		String testname = '%'+ name + "%".toLowerCase();
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.like("firstname",testname ));
		List<Student>students=criteria.list();
		session.close();
		return students;
		

		
	}
	
	public List<Instructor> getNamesLike (String like){
		Session session =ConnectionUtil.getSession();
		Query query=session.getNamedQuery("findInstructorByNameHql").setString("name",like);
		List<Instructor>i=query.list();
		return i;
	}
	public List<Instructor> getInstructorById (String like){
		Session session =ConnectionUtil.getSession();
		Query query=session.getNamedQuery("findInstructorByNameHql").setString("name",like);
		List<Instructor>i=query.list();
		return i;
	}
	public Instructor getInstructorById(int id){
		Session session = ConnectionUtil.getSession();
		Instructor i=null;
		try{
			i=(Instructor) session.get(Instructor.class, id);
		}
		catch(HibernateException e){ e.printStackTrace();}
		finally{
			session.close();
		}
		return i;
	}
	
	public Instructor loadInstructorById(int id){
		Session session = ConnectionUtil.getSession();
		Instructor i=null;
		try{
			i=(Instructor) session.load(Instructor.class, id);
		}
		catch(HibernateException e){ e.printStackTrace();}
		finally{
			session.close();
		}
		return i;
	}
	/*
	 * query api 
	 * queries use hibernate query languages - not SQL 
	 * hql uses clas and property names insteave of table and colimn names 
	 * (hql uses entity not table) 
	 */
	public List<Student> queryDemo(String name){
		name="%"+name+"%";
		Session session=ConnectionUtil.getSession();
		String hql="from Student where lower(firstname) like:param";
		//like:param is the same as like=? but giving it a viarable lol 
		Query query=session.createQuery(hql);
		query.setParameter("param", name);
		List<Student> students = query.list();
		session.close();// close session  ^ is why 
		return students;
		
	}

}
