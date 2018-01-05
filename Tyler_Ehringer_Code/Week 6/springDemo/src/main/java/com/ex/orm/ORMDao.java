package com.ex.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ORMDao {

	private SessionFactory sf;

	public ORMDao() {
		super();
	}

	@Transactional()
	public List<Bear> getBears() {
		return sf.getCurrentSession().createQuery("from Bear").list();
	}

	@Transactional()
	public List<Bear> getBearsCriteria() {
		Session s = sf.getCurrentSession();
		List<Bear> bears = s.createCriteria(Bear.class).list();
		return bears;
	}

	@Transactional(readOnly = false)
	public void buildABear(Bear bear) {
		Session s = sf.getCurrentSession();
		s.save(bear);
	}

	public ORMDao(SessionFactory sessionFactory) {
		super();
		this.sf = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sf;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

}
