package com.ex.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ORMDao {
	
	private SessionFactory sf;

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional()
	public void buildABear(Bear bear) {
		Session s = sf.getCurrentSession();
		s.save(bear);
	}
	
	public List<Bear> getBears(){
		Session s = sf.getCurrentSession();
		List<Bear> bears = s.createQuery("from Bear").list();
		return bears;
	}
	
}
