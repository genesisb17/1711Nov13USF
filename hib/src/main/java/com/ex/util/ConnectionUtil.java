package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil 
{

/*
	private static sessionConfig()
	{
		//private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Configuration config = new Configuration();
		config.configure("src/hibernate.cfg.xml");
	}
*/
	@SuppressWarnings("deprecation")
	 private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 public static Session getSession()
	 {
		 return sessionFactory.openSession();
	 }
}
