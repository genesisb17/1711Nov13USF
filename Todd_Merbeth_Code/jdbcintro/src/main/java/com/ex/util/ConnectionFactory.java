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
	 * Provides method callers with the CF object
	 * -- synchronized to prevent 2 threads from 
	 * 	  creating thread object simultaneously
	 */
	public static synchronized ConnectionFactory getInstance() {
		if(build==true) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("C:/Users/toddm_000/git/1711Nov13USF/Todd_Merbeth_Code/jdbcintro/src/main/resources/application.properties"));
			
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(
						prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
						// values from app.properties file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
