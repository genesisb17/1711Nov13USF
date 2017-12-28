package com.test.orm;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class dao {

	@Autowired
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	public void addText(Hello hello) {
		Session s = sf.getCurrentSession();
		s.save(hello);
	}
}
