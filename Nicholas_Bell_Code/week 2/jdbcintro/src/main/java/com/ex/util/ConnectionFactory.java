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
	 * provides method callers with the CF object
	 * --synchronized to prevent 2 threads from 
	 * 		from creating object thread simultaneously
	 */
	public static synchronized ConnectionFactory getInstance() {
		if (build) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("C:/Users/Nick/Nicholas_git_repos/1711Nov13USF/Nicholas_Bell_Code/week 2/jdbcintro/src/main/resources/application.properties"));
			Class.forName(prop.getProperty("driver"));	
			  conn = DriverManager.getConnection(
				 prop.getProperty("url"),
				 prop.getProperty("usr"),
				 prop.getProperty("pwd"));
		/*
		 * The DriverManager provides a baseic serive for managing jdbc drivers. 
		 * as part of its init, the DriverManager class will attempts to load the
		 *  driver classes referenced in the jdbc.drivers system property.
		 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;

	}

}
