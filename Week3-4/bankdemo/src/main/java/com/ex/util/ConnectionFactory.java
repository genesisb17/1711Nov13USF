package com.ex.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory(){
		build = false;
	}
	
	/*
	 * provides method callers with the CF object
	 * and synchronized to prevent 2 threads from creating
	 * connection object simultaneously 
	 */
	public static synchronized ConnectionFactory getInstance(){
		if(build == true){
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try{
			Properties prop = new Properties();
			// location for properties file will be wherever you create it. include full file path
			prop.load(new FileReader("C:/Users/Andy/my_git_repos/1711Nov13USF/Week3-4/bankdemo/src/main/java/com/ex/util/database.properties"));
			// register JDBC driver
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"), 
					prop.getProperty("pwd"));
					/*
					 *  The DriverManager provides a basic service for managing a set
					 *   of JDBC drivers. As part of its initialization, the DriverManager 
					 *   class will attempt to load the driver classes
					 *    referenced in the "jdbc.drivers" system property.		
					 */
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
