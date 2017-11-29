package bank.ex.utility;

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
	private static String propFile = "C:/Users/fabreu/my_git_repos/1711Nov13USF/Week2/BankSystem/src/main/resources/Application.properties";
	
	private ConnectionFactory() {
		build=false;
	}
	
	
	/*Provides method callers with the CF object
	 * synchronized to prevent 2 threads from creating 
	 * thread object simultaneously
	 */
	public static synchronized ConnectionFactory getINstance() {
		if(build ==true) {
			cf = new ConnectionFactory();
		}
		return cf;		
	}
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			/*
			 * The Driver manager provides a basic service for managing a set of
			 * JDBC drivers needed in order to use the jdbc api. 
			 * AS a part of initialization, the DriverManager Class
			 * will attempt to load the driver classes references in the jdbc.drivers system property
			 * getConnection(string url, string username, string password) thrwos sqlexception
			 */
			prop.load( new FileReader(propFile));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));	
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
