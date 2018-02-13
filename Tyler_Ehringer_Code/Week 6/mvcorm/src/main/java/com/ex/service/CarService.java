package com.ex.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.model.Car;

@Service
@Transactional
public class CarService {
	
	@Autowired
	private SessionFactory sf;
	
//	public void setSessionFactory(SessionFactory s) {
//		this.sf = s;
//	}
	
	public void addCar(Car c) {
		sf.getCurrentSession().save(c);
	}
	
	public Car getByLicensePlate(String plateNumber) {
		return (Car) sf.getCurrentSession().createCriteria(Car.class).add(Restrictions.eq("licensePlate", plateNumber)).uniqueResult();
	}

}
