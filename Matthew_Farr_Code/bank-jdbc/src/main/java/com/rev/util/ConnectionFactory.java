package com.rev.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static boolean build = true;
	private static String filepath = "C:/Users/Dad/workspaces/Week2/bank-jdbc/src/main/resources/application.properties";
	
	private ConnectionFactory() {
		build = false;
	}
	
	/*
	 * Provides callers with the cf object
	 * synchronized to prevent 2 threads from creating objects simultaneously
	 */
	public static synchronized ConnectionFactory getInstance() {
		if (build == true)
			cf = new ConnectionFactory();
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(filepath));
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection( prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
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
