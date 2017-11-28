package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Accounts;
import com.ex.pojos.Users;
import com.ex.util.ConnectionFactory;

public class DAOImpl implements DAO {

	// Create account by adding users to the database
	public Users addUser(Users u) {

		String username;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql_select = "select username from users where username = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql_select);
			ps1.setString(1, u.getUsername());
			ResultSet info = ps1.executeQuery();
			
			while(info.next()) {
				username = info.getString("USERNAME");
				if(u.getUsername().equals(username)) {
					return null;
				}
			}
			String sql_insert = "insert into users (firstname, lastname, username, password) "
					     + "values(?, ?, ?, ?)";
			PreparedStatement ps2 = conn.prepareStatement(sql_insert);
			ps2.setString(1, u.getFirstname());
			ps2.setString(2, u.getLastname());
			ps2.setString(3, u.getUsername());
			ps2.setString(4, u.getPassword());
			int rows = ps2.executeUpdate();
				
			// If number of rows affected in 1 it means that the row is added
			if(rows == 1) {
				conn.commit();
				return u;
			}	
			System.out.println("Failed to execute query");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Verify that the user-name is correct to login
	public Users VerifyUsernameToLogin(String username) {
		
		Users u = new Users();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql_select = "select * from users where username = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql_select);
			ps1.setString(1, username);
			ResultSet info = ps1.executeQuery();
			
			while(info.next()) {
				u.setUsername(info.getString("USERNAME"));
				if(u.getUsername().equals(username)) {
					u.setU_id(info.getInt("U_ID"));
					u.setFirstname(info.getString("FIRSTNAME"));
					u.setLastname(info.getString("LASTNAME"));
					u.setPassword(info.getString("PASSWORD"));
					return u;
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Verify that the password is correct to login
	public Users VerifyPasswordToLogin(String password, String username) {
		
		Users u = new Users();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql_select = "select * from users where username = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql_select);
			ps1.setString(1, username);
			ResultSet info = ps1.executeQuery();
			
			while(info.next()) {
				u.setPassword(info.getString("PASSWORD"));
				if(u.getPassword().equals(password)) {
					u.setU_id(info.getInt("U_ID"));
					u.setFirstname(info.getString("FIRSTNAME"));
					u.setLastname(info.getString("LASTNAME"));
					u.setUsername(info.getString("USERNAME"));
					return u;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Withdraw from account
	@Override
	public Users withdraw(Users u, Accounts a, double d) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql_select = "select * from accounts where user_id = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql_select);
			ps1.setInt(1, a.getU_id());
			ResultSet info = ps1.executeQuery();
			
			// If the user already has a balance and wants to perform more transactions (UPDATE)
			if(info.next()) {
				conn.setAutoCommit(false);
				double newBalance = info.getDouble("BALANCE") - d;
				String sql_update = "update accounts set balance = ? where user_id = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql_update);
				ps2.setDouble(1, newBalance);
				ps2.setInt(2, a.getU_id());
				
				int rows = ps2.executeUpdate();
				// If number of rows affected in 1 it means that the row is added
				if(rows == 1) {
					conn.commit();
					return u;
				}
			}
			// If this is the user's first transaction (INSERT)
			else {
				String sql_insert = "insert into accounts (user_id, balance) values (?, ?)";
				PreparedStatement ps3 = conn.prepareStatement(sql_insert);
				ps3.setInt(1, a.getU_id());
				ps3.setDouble(2, -d);
				ps3.executeUpdate();
				return u;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	// Deposit into account
	@Override
	public Users deposit(Users u, Accounts a, double d) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql_select = "select * from accounts where user_id = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql_select);
			ps1.setInt(1, a.getU_id());
			ResultSet info = ps1.executeQuery();
			System.out.println("Inside DEPOSIT");

			// If the user already has a balance and wants to perform more transactions (UPDATE)
			if(info.next()) {
				conn.setAutoCommit(false);
				double newBalance = info.getDouble("BALANCE") + d;
				String sql_update = "update accounts set balance = ? where user_id = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql_update);
				ps2.setDouble(1, newBalance);
				ps2.setInt(2, a.getU_id());
				System.out.println("Inside UPDATE");

				int rows = ps2.executeUpdate();
				// If number of rows affected in 1 it means that the row is added
				if(rows == 1) {
					conn.commit();
					return u;
				}
				System.out.println("Failed to execute query");
			}
			// If this is the user's first transaction (INSERT)
			else {
				String sql_insert = "insert into accounts (user_id, balance) values (?, ?)";
				PreparedStatement ps3 = conn.prepareStatement(sql_insert);
				ps3.setInt(1, u.getU_id());
				ps3.setDouble(2, d);
				ps3.executeUpdate();
				System.out.println("Inside INSERT");

				return u;
			}				
		} catch (SQLException e) {
			System.out.println("Inside Catch");
			e.printStackTrace();
		}
		return null;	
	}

	// View Balance
	public Accounts viewBalance(Users u) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Accounts a = new Accounts();
			conn.setAutoCommit(false);
			String sql_select = "select balance from accounts where user_id = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql_select);
			ps1.setInt(1, u.getU_id());
			ResultSet info = ps1.executeQuery();
			
			if(info.next()) {
				a.setBalance(info.getDouble("BALANCE"));
				return a;		
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}	
}
