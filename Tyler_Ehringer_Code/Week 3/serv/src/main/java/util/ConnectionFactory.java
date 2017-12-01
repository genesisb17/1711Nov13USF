package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static boolean build = true;
	private String propertiesPath = "C:/Users/tyler/my_git_repos/1711Nov13USF/Tyler_Ehringer_Code/Week 2/bank/src/main/resources/application.properties";
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build == true) cf = new ConnectionFactory();
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties(); 
		try {
			prop.load(new FileReader(propertiesPath));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
