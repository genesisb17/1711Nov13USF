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
			String sql = "insert into USERS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD) values(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			//addUsera(u);
			ps.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	public void addUsera(newUser u) 
	{
		// TODO Auto-generated method stub
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql1 = "insert into ACCOUNTS(USER_ID,BALANCE) values(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, u.getId());
			ps.setDouble(2, u.getBalance());
			ps.executeUpdate();
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void change1(String old,String n) 
	{
		String[] about = null;
		// TODO Auto-generated method stub
		int a=0;
		final String filename ="src/main/resources/bank.txt";
		File f1 = new File(filename);
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			
			String line = null;
			while((line = br.readLine())!=null)
			{
				//newUser v = new newUser();
				about = line.split(":");
				int j;
				for(j=0;j<about.length-2;j++) //*
				{
					if(about[j].equalsIgnoreCase(old))
					{		
						a = 1;
						about[j]=n;
						//write old file info
						//error is here
						break;
					}
				}
			}
				//delete file and replace it
			
			if(a==1)
			{
				br.close();
				f1.delete();
				f1.createNewFile();
				
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))//true appending not rewriting
				{
					//should not be able to add users with a username that already exists
					//add logic to validate				
					StringBuilder strBuilder = new StringBuilder();
					for (int i = 0; i < about.length; i++) 
					{
					   strBuilder.append(":"+about[i]);
					}
					String newString = strBuilder.toString();
					bw.write(newString);
				}
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch(FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void change(String username,int deposit) 
	{
		newUser u = new newUser();
		int balance;
		Scanner sc = new Scanner(System.in);
		System.out.println("To verify what is your password??");
		String pass = sc.nextLine();
		u = getUser(username,pass);
		u.setBalance(u.getBalance()+deposit);
		System.out.println(u.getBalance());
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
}