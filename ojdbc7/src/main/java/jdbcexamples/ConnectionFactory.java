package jdbcexamples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionFactory 
{
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory()
	{
		build = false;
	}
	/*
	 * provides method callers with the cf object 
	 * -- synchronized to prevent 2 threads from 
	 * creating thread object simultaneously
	 */
	public static synchronized ConnectionFactory getInstance()
	{
		if(build ==true)
		{
			cf = new ConnectionFactory();
		}
		return cf;
	}
	public Connection getConnection()
	{
		Connection conn =null;
		Properties prop =new Properties();
		try 
		{
			prop.load(new FileReader("C:\\Users\\Bruce Wayne\\my_git_repos\\1711Nov13USF\\ojdbc7\\src\\main\\resources\\application.properties"));
			Class.forName(prop.getProperty("driver"));			
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pwd"));
			/*0
			 * The Driver Manager provides a basic service for managin a set of jdbc drivers
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
	
