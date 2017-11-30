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
	
	private ConnectionFactory(){
		build = false;
	}
	/*
	 * provides method callers with the CF object 
	 * -- synchronized to prevent 2 threads from 
	 *    creating thread object simultaneously
	 */
	public static synchronized ConnectionFactory getInstance(){
		if(build==true){
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("C:/Users/Genesis/my_git_repos/1711Nov13USF/Week2/jdbcintro/src/main/resources/application.properties"));
		
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		
			/*
			 * The DriverManager provides a basic service for managing a 
			 * set of JDBC drivers. As part of its initialization, the 
			 * DriverManager class will attempt to load the driver classes
			 * referenced in the jdbc.drivers system property
			 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
		
	}
}
