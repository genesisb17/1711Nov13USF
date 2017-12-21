package com.ex.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ORMDao {

	private SessionFactory sf;

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional(readOnly=false)
	public void buildABear(Bear bear) {
		Session s = sf.getCurrentSession();
		s.save(bear);
	}
	
}
