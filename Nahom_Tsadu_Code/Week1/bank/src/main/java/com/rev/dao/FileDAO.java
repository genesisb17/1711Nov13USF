package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public class FileDAO implements DAO{

	static String filename = "src/main/resources/bank.txt";
	private OracleConfiguration oc = OracleConfiguration.getInstance();
	
	public User addUser(User u) {
		User user = new User();
	    PreparedStatement stmt = null;
	    String query = "INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
	    String[] key = new String[1];
	    key[0] = "user_id";
	    
	    try(Connection connection = oc.getConnection()){
	    	connection.setAutoCommit(false);
	        stmt = connection.prepareStatement(query, key);
	        stmt.setString(1, u.getFname());
	        stmt.setString(2, u.getLname());
	        stmt.setString(3, u.getUsername());
	        stmt.setString(4, u.getPassword());
	        int rows = stmt.executeUpdate();
	        
	        if(rows != 0){
	        	ResultSet rs = stmt.getGeneratedKeys();
	        	while(rs.next()){user.setId(rs.getInt(1));}
	        	user.setFname(u.getFname());
	        	user.setLname(u.getLname());
	        	user.setUsername(u.getUsername());
	        	user.setPassword(u.getPassword());
	        	connection.commit();
	        	createAccount(u.getId());
	        }
	        
	    }catch (SQLException e) {
	        e.printStackTrace();
	    } 
	 return user;
	}

	public User getUser(String username) {
		ArrayList<User> userList = getAllUsers();
		if(!userList.isEmpty()){
			for(User u: userList){
				if(u.getUsername().equals(username)){
					return u;
				}
			}
		}
	 return null;
	}

	@Override
	public Account deposit(Account account) {
		System.out.println(account.toString());
	    try(Connection connection = oc.getConnection()){
	    	connection.setAutoCommit(false);
	    	String query = "UPDATE ACCOUNT SET ACCOUNT.BALANCE = ? WHERE ACCOUNT.ACCOUNT_ID = ?";
		    PreparedStatement stmt = connection.prepareStatement(query);
	        stmt = connection.prepareStatement(query);
	        stmt.setDouble(1, account.getBalance());
	        stmt.setInt(2, account.getAccountId());
	        stmt.executeUpdate();
	        connection.commit();
	        return account;
	    }catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    } 
	}
	
	@Override
	public Account withdraw(Account account) {
		System.out.println(account.toString());
	    try(Connection connection = oc.getConnection()){
	    	connection.setAutoCommit(false);
	    	String query = "UPDATE ACCOUNT SET ACCOUNT.BALANCE = ? WHERE ACCOUNT.ACCOUNT_ID = ?";
		    PreparedStatement stmt = connection.prepareStatement(query);
	        stmt = connection.prepareStatement(query);
	        stmt.setDouble(1, account.getBalance());
	        stmt.setInt(2, account.getAccountId());
	        stmt.executeUpdate();
	        connection.commit();
	        return account;
	    }catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    } 
	}

	public Account createAccount(int userId) {
		Account account = new Account();
	    PreparedStatement stmt = null;
	    String query = "INSERT INTO ACCOUNT(USER_ID, BALANCE) VALUES (?, ?)";
	    String[] key = new String[1];
	    key[0] = "account_id";
	    
	    try(Connection connection = oc.getConnection()){
	    	connection.setAutoCommit(false);
	        stmt = connection.prepareStatement(query, key);
	        stmt.setInt(1, userId);
	        stmt.setDouble(2, 0);
	        int rows = stmt.executeUpdate();
	        
	        if(rows != 0){
	        	ResultSet rs = stmt.getGeneratedKeys();
	        	while(rs.next()){account.setAccountId(rs.getInt(1));}
	        	account.setUserId(userId);
	        	account.setBalance(0);
	        	connection.commit();
	        }
	        
	    }catch (SQLException e) {
	        e.printStackTrace();
	    } 
	 return account;
	}
	
	
	public ArrayList<Account> getAccountsByUserID(int userId) {
			
			ArrayList<Account> accounts = new ArrayList<Account>();
		    
		    try(Connection connection = oc.getConnection()){
		    	String query = "SELECT * FROM ACCOUNT WHERE USER_ID = ?";
		    	PreparedStatement stmt =connection.prepareStatement(query);
			    
		        stmt = connection.prepareStatement(query);
		        stmt.setInt(1, userId);
		        ResultSet rs = stmt.executeQuery();

		        while(rs.next()){
		        	Account account = new Account();
		        	account.setAccountId(rs.getInt(1));
		        	account.setUserId(rs.getInt(2));
		        	account.setBalance(rs.getDouble(3));
		        	//System.out.println(rs.getDouble(3));
		        	accounts.add(account);
		        }
		        
		    }catch (SQLException e) {
		        e.printStackTrace();
		    } 
		    
	 return accounts;
	}
	
	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();
	    Statement stmt = null;
	    String query = "SELECT * FROM Users";
	    try(Connection connection = oc.getConnection()){
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while(rs.next()){
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
	    }catch (SQLException e) {
	        e.printStackTrace();
	    } 
	 return userList;
	}
}
