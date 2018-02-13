package com.ex.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ex.model.Driver;

public class DriverService {
	
	@Autowired
	private SessionFactory sf;
	
	public void addDriver(Driver d) {
		sf.getCurrentSession().save(d);
	}
	
	public Driver getDriverById(Long id) {
		return (Driver) sf.getCurrentSession().createCriteria(Driver.class).add(Restrictions.idEq(id)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> getAllDrivers(){
		return sf.getCurrentSession().createCriteria(Driver.class).list();
	}

}
