package com.ex.util;

import java.net.URL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtil {
	
	private static final SessionFactory sessionFactory = sessionFactoryCreator();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory sessionFactoryCreator() {
		try {
			URL r1 = ConnectionUtil.class.getResource("/hibernate.cfg.xml");
			Configuration configuration = new Configuration();
			configuration.configure(r1);
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			return configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex) {
			System.err.println("Initial session factory failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	
//	@SuppressWarnings("deprecation")
//	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
//	
//	public static Session getSession() {
//		return sf.openSession();
//	}
//	private static void sessionConfig() {
//		Configuration config = new Configuration();
//		config.configure("src/hibernate.cfg.xml");
//	}
	
}
