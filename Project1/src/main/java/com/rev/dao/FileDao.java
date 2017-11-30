package com.rev.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojo.R;

public class FileDao implements DAO 
{
	@Override
	public void addRtype(String s) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE)Values(?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}
	@Override
	public void adders_user_roles(String s) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "insert into ers_user_roles(USER_ROLE)VALUES(?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}
	
	@Override
	public void addRStatus(String s) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "insert into ERSREIMBURSEMENTSTATUS(REIMB_STATUS)Values(?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}
	
	@Override
	public void adders_users(String user,String pass,String first,String last,String email) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "insert into ers_users(PASSWORD , LASTNAME , FIRSTNAME , EMAIL , USERNAME)Values(?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, last);
			ps.setString(3, first);
			ps.setString(4, email);
			ps.setString(5, user);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}
	

	
	@Override
	public R getReimbursements(String username,String password) 
	{
		// TODO Auto-generated method stub
		R r =new R();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	@Override
	public String getRtype(int i) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getRStatus(int i) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int geters_users(String user, String pass) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select U_ID from ers_users where USERNAME =? and password =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet info = ps.executeQuery();
			while(info.next())
			{
				return info.getInt(1);

			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	return 0;
	}
	
	//QC
	@Override
	public String geters_user_roles(int i) {
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select USER_ROLE from ers_users where ERS_USER_ROLE_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while(info.next())
			{
				return info.getString(1);

			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}