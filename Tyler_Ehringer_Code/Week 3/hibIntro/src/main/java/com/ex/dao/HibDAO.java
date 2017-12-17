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

public class HibDAO {
	
	public Student addStudent(Student s) {
		Session session = ConnectionUtil.getSession();
		Transcript t = new Transcript();
		try {
			Transaction tx = session.beginTransaction();
			int tid = (int) session.save(t);
			t.setId(tid);
			s.setTranscript(t);
			int sid = (int) session.save(s);
			s.setId(sid);
			tx.commit();
		}finally {
			session.close();
		}
		return s;
	}
	
	public List<Student> getAllStudents(){
		Session ses = ConnectionUtil.getSession();
		Criteria cri = ses.createCriteria(Student.class);
		List<Student> students = cri.list();
		ses.close();
		return students;
	}
	
	public List<Student> getStudentsByName(String name){
		String testname = "%" + name + "%";
		Session ses = ConnectionUtil.getSession();
		Criteria cri = ses.createCriteria(Student.class).add(Restrictions.like("fname", testname).ignoreCase());
		List<Student> students = cri.list();
		ses.close();
		return students;
	}
	
	
	public List<Student> queryDemo(String name){
		name = "%"+name+"%";
		Session ses = ConnectionUtil.getSession();
		String hql = "from Student where lower(fname) like :param";
		Query q = ses.createQuery(hql);
		q.setParameter("param", name.toLowerCase());
		List<Student> students = q.list();
		ses.close();
		return students;
	}
	

}
