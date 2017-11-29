package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ex.util.ConnectionFactory;
import com.rev.pojos.User;

public class ImplDAO implements DAO{

	public void addUser(User u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
		
			conn.setAutoCommit(false);
			String sql = "insert into users (U_ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) values (?, ?, ?, ?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,u.getId());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getUserName());
			ps.setString(5, u.getPassword());
			int rows = ps.executeUpdate();
			conn.commit();		
			System.out.println("Account has been successfully created!");
			//System.out.println("\n");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean findUser(String username) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			
			if(info.next()) {
				
				System.out.println("result from query: " + info.getString(2));
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return false;
	}

	public boolean getUser(String username, String password) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();
			
			if(info.next() == false) {
				return false;
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public User getUser(String username) {
		
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			
			if(info.next() == false) {
				return null;
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	public void viewBalance(User u) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			//find the user id from the username from users table
			conn.setAutoCommit(false);
//			String sql = "select u_id from users where username = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1,user);
//			ResultSet info = ps.executeQuery();
//			info.next();
//			int retID = info.getInt(1);
			int id = u.getId();
			
			//now search accounts table with user id to retrieve balance
			String sql2 = "select balance, acc_id from accounts where user_id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id);
			ResultSet info2 = ps2.executeQuery();
			while(info2.next()) {
				int balance = info2.getInt(1);
				int account = info2.getInt(2);
				System.out.println("Account " + account +": $" + balance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setAccount(User u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into accounts (ACC_ID,USER_ID,BALANCE) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (1000 + u.getId()));
			ps.setString(2, (String.valueOf(u.getId())));
			ps.setDouble(3, u.getBalance());
			int rows = ps.executeUpdate();
			conn.commit();	
			System.out.println("Thanks for being a valued customer!\n");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}

	public void deposit(User u, double amount,int acc) {
			
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			//find the user id from the username from users table
			conn.setAutoCommit(false);
//			String sql = "select u_id from users where username = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1,user);
//			ResultSet info = ps.executeQuery();
//			info.next();
//			int retID = info.getInt(1);
			int id = u.getId();
			
			//have to retrieve current balance with the retrieved user id
			String sql2 = "select balance from accounts where user_id = ? and acc_id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id);
			ps2.setInt(2, acc);
			ResultSet info2 = ps2.executeQuery();
			info2.next();
			double initialBalance = info2.getInt(1);
			double newBalance = amount + initialBalance;
			
			//update balance for user in accounts table with new balance
			String sql3 = "update accounts set balance  = ? where user_id = ?";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setDouble(1, newBalance);
			ps3.setInt(2, id);
			//ps3.setInt(3, acc);
			ps3.executeUpdate();
			conn.commit();	
			System.out.println("Your new balance for account " + acc + " is: " + newBalance);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void withdraw(User u, double amount,int acc) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);			
			//find the user id from the username from users table
//			conn.setAutoCommit(false);
//			String sql = "select u_id from users where username = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1,user);
//			ResultSet info = ps.executeQuery();
//			info.next();
//			int retID = info.getInt(1);
			int id = u.getId();
			
			//have to retrieve current balance with the retrieved user id
			String sql2 = "select balance from accounts where user_id = ? and acc_id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id);
			ps2.setInt(2, acc);
			ResultSet info2 = ps2.executeQuery();
			info2.next();
			double initialBalance = info2.getInt(1);
			double newBalance = initialBalance - amount;
			
			//check for overdraft. $10 fee for overdrafting
			if(newBalance < 0) {
				
				System.out.println("Oh, no! It seems like you have overdrafted.");
				System.out.println("This will incur a $10 overdraft fee.");
				newBalance = newBalance - 10;
			}
			
			//update balance for user in accounts table with new balance
			String sql3 = "update accounts set balance  = ? where user_id = ? and acc_id = ?";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setDouble(1, newBalance);
			ps3.setInt(2, id);
			ps3.setInt(3, acc);
			ps3.executeUpdate();
			conn.commit();	
			System.out.println("Your new balance for account " + acc + " is: " + newBalance);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}

	//function to create another account for an existing user
	public void createAnotherAccount(User u) {
			
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			//check if user has more than 2 accounts
			String sql = "select count(user_id) from accounts where user_id = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			info.next();
			int accCount = info.getInt(1);
			if(accCount >= 2)
			{
				System.out.println("Sorry, but you cannot create more than 2 accounts.");
				return;
			}
			
			else {
				
				//if user has less than two accounts, then create another one
				setAccount(u);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
