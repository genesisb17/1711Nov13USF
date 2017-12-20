package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
//	private static SessionFactory sessionFactoryCreator() {
//		try {
//			URL r1 = ConnectionUtil.class.getResource("/hibernate.cfg.xml");
//			Configuration configuration = new Configuration();
//			configuration.configure(r1);
//			serviceRegistry = new ServiceRegistryBuilder()
//					.applySettings(configuration.getProperties()).buil
//			return cofiguration.buildSessionFactory(serviceRegistry);
//		} catch(Throwable ex) {
//			// make sure you log the exception, as it might be swallowed
//			System.err.print("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
	
	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory =
			new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
//	private static sessionConfig() {
//		
//		Configuration config = new Configuration();
//		config.configure("src/hibernate.cfg.xml")
//	}
	
}
