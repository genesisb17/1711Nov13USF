package com.ex.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	/*
	 *  provides method callers with the CF object
	 *  	- synchronized to prevent multiple threads from creating thread object simultaneously
	 */
	public static synchronized ConnectionFactory getInstance() {
		if(build == true) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("C:/Users/wezle/my_git_repos/1711Nov13USF/Wezley_Singleton_Code/week_2/"
					+ "jdbc_demo/src/main/resources/application.properties"));
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("usr"), 
					prop.getProperty("pw"));
			
			/*
			 *  The DriverManager provides a basic service for managing a
			 *  set of JDBC drivers. As part of its initialization, the
			 *  DriverManager class will attempt to load the driver classes
			 *  referenced in the jdbc.drivers system properly
			 */
		} 
		
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} 
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return conn;
		
	}
	
}
