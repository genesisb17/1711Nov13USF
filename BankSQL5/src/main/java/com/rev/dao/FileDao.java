package com.rev.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.rev.pojo.newUser;

public class FileDao implements DAO 
{
	final String filename ="src/main/resources/bank.txt";
	File f = new File(filename);
	public void addUser(newUser u) 
	{
		// TODO Auto-generated method stub
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "insert into USERS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.executeUpdate();
			conn.commit();
			conn.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
		addUsera(u);
	}

	public void addUsera(newUser u) 
	{
		// TODO Auto-generated method stub
		newUser u1 = new newUser();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql1 = "insert into ACCOUNTS(USER_ID,BALANCE) values(?,?)";
			u1 = getUser(u.getUsername(),u.getPassword());
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, u1.getId());
			ps.setDouble(2, u.getBalance());
			ps.executeUpdate();
			conn.commit();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
	
	}
	
	@Override
	public newUser getUser(String username,String password) 
	{
		// TODO Auto-generated method stub
		newUser u = new newUser();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from USERS where USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();
			while(info.next())
			{
				u.setId(info.getInt(1));
				System.out.println(u.getId());
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
			}
			sql = "select BALANCE FROM ACCOUNTS WHERE USER_ID =?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, u.getId());
			ResultSet info1 = p.executeQuery();
			while(info1.next())
			{
				u.setBalance(info1.getDouble(1));
				//System.out.println(info1.getDouble(1));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void change1(String u,String p) 
	{
		newUser u1 = new newUser();
		u1 = getUser(u,p);
		System.out.println("what is the user transfer you want??(username)");
		Scanner sc = new Scanner(System.in);
		String u2 =sc.nextLine();
		System.out.println("what is the pass transfer you want??(password)");
		String p2 =sc.nextLine();
		newUser u3 = new newUser();
		u3 = getUser(u2,p2);
		System.out.println("how much do you want??");
		double deposit = sc.nextDouble();
		try
		{
			if(u1.getUsername()!=null||u3.getUsername()!=null)
			{
				change(u1.getUsername(),deposit*-1);
				change(u3.getUsername(),deposit);
			}
		}
		catch(Exception e)
		{
			System.out.println("try again");
		}
	}
	
	public void change(String username,double deposit) 
	{
		newUser u = new newUser();
		int balance;
		Scanner sc = new Scanner(System.in);
		System.out.println("To verify what is your password?? of "+username);
		String pass = sc.nextLine();
		u = getUser(username,pass);
		u.setBalance(u.getBalance()+deposit);
		//System.out.println(u.getBalance());
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, u.getBalance());
			ps.setInt(2, u.getId());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String u, String p) 
	{
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			newUser u1 =new newUser();
			String sql = "DELETE USERS WHERE U_ID=?";
			u1 = getUser(u,p); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u1.getId());
			ps.executeUpdate();
			
			String sql1 = "DELETE ACCOUNTS WHERE USER_ID=?";
			PreparedStatement p1 = conn.prepareStatement(sql);
			p1.setInt(1, u1.getId());
			p1.executeUpdate();
			conn.commit();
			conn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}