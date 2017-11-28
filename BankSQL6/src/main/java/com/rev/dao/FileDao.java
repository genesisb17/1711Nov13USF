package com.rev.dao;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojo.Account;
import com.rev.pojo.newUser;

public class FileDao implements DAO 
{
	final String filename ="src/main/resources/bank.txt";
	File f = new File(filename);

	public void addUser(newUser u,int j) 
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
		addUsera(u,j);
	}

	public void addUsera(newUser u,int j) 
	{
		// TODO Auto-generated method stub
		newUser u1 = new newUser();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql1 = "insert into ACCOUNTS(USER_ID,BALANCE) values(?,?)";
			u1 = getUser(u.getUsername(),u.getPassword(),j);
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
	public newUser getUser(String username,String password,int j) 
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
			sql = "select BALANCE FROM ACCOUNTS WHERE USER_ID =? and acc_id = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, u.getId());
			p.setInt(2, j);
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
	public void change1(String u,String p,int j) 
	{
		newUser u1 = new newUser();
		u1 = getUser(u,p,j);
		System.out.println("what is the user transfer you want??(username)");
		Scanner sc = new Scanner(System.in);
		String u2 =sc.nextLine();
		System.out.println("what is the pass transfer you want??(password)");
		String p2 =sc.nextLine();
		newUser u3 = new newUser();
		u3 = getUser(u2,p2,j);
		System.out.println("how much do you want??");
		double deposit = sc.nextDouble();
		try
		{
			if(u1.getUsername()!=null||u3.getUsername()!=null)
			{
				change(u1.getUsername(),deposit*-1,j);
				change(u3.getUsername(),deposit,j);
			}
		}
		catch(Exception e)
		{
			System.out.println("try again");
		}
	}
	
	public void change(String username,double deposit,int j) 
	{
		newUser u = new newUser();
		int balance;
		Scanner sc = new Scanner(System.in);
		System.out.println("To verify what is your password?? of "+username);
		String pass = sc.nextLine();
		u = getUser(username,pass,j);
		u.setBalance(u.getBalance()+deposit);
		//System.out.println(u.getBalance());
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ? and acc_id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, u.getBalance());
			ps.setInt(2, u.getId());
			ps.setInt(3, j);
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

	}

	@Override
	public ArrayList<Account> getAccount(newUser u) 
	{
		ArrayList <Account> a = new ArrayList<Account>();
		Account e1 = new Account();
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
		String sql = "select BALANCE FROM ACCOUNTS WHERE USER_ID =?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, u.getId());
		ResultSet info1 = p.executeQuery();
		int i =0;
		while(info1.next())
		{
			e1.setA_id(info1.getInt(1));
			e1.setU_id(info1.getInt(2));
			e1.setBalance(info1.getInt(3));
			a.add(e1);
			System.out.println(a.get(i).getA_id()+' '+a.get(i).getBalance()+' ');
			//System.out.println(info1.getDouble(1));
		}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addAccount(newUser u,double balance,int user_id) 
	{
		// TODO Auto-generated method stub

		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql1 = "insert into ACCOUNTS(USER_ID,BALANCE) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, user_id);
			ps.setDouble(2, 0.0+balance);
			ps.executeUpdate();
			conn.commit();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}	
	}
	public void getArtbyid(newUser u) 
	{
		// TODO Auto-generated method stub
		newUser art = new newUser();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from ACCOUNTS where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId()); //sets info
			ResultSet info = ps.executeQuery();
			//System.out.println("here are the values");
			System.out.println("here are the values");
			while(info.next())
			{
				System.out.println("BALANCE: " +info.getDouble("BALANCE")+" ACC_ID: "+info.getInt("ACC_ID"));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}