package com.ex.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ex.domain.FlashCard;

@Transactional
public class Dao {
	

	private SessionFactory sf;

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	public void addFc(FlashCard fc) {
		Session s = sf.getCurrentSession();
		s.save(fc);
	}

}
