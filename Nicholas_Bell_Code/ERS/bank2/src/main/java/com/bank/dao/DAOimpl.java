package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;


public class DAOimpl implements DAO{

	@Override
	public User addUser(User u) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			//sql command example 
			//insert into artist (name) values ('Beyonce');
			String sql = "insert into users (firstname, lastname, username, password) "
					+ "values (?,?,?,?)";
			String[] key= new String[1];
			key[0] = "U_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			int rows = ps.executeUpdate();
			//int id = 0;
			
			if(rows !=0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
				//	id = pk.getInt(1);
					user.setUser_id(pk.getInt(1));
				//	user.setFirstname(pk.getString("FIRSTNAME"));
				//	user.setLastname(pk.getString("LASTNAME"));
				//	user.setUsername(pk.getString("USERNAME"));
				//	user.setPassword(pk.getString("PASSWORD"));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(String username) {
		User user = new User();
		user.setUser_id(-1);
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			//sql command example 
			//insert into artist (name) values ('Beyonce');
			String sql = "select * from users "
					+ "where username = (?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			//int rows = ps.executeUpdate();
			//int id = 0;
			
			//if(rows !=0) {
				ResultSet pk = ps.executeQuery();
			while(pk.next()) {
			//	id = pk.getInt(1);
				user.setUser_id(pk.getInt("U_ID"));
				user.setFirstname(pk.getString("FIRSTNAME"));
				user.setLastname(pk.getString("LASTNAME"));
				user.setUsername(pk.getString("USERNAME"));
				user.setPassword(pk.getString("PASSWORD"));
			}
				//conn.commit();
			//}
			if(user.getUser_id() == -1) {
				user = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public Account changeBalance(Account a, boolean c, double d) {
		Account acc = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update ACCOUNTS set (BALANCE) = (?) where ACC_ID = (?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			Double b = new Double(0);
			if(c) b = a.getBalance() + d;
			else  b = a.getBalance() - d;
			ps.setDouble(1, b);
			ps.setInt(2, a.getAccId());
			int rows = ps.executeUpdate();
			if (rows > 0){
				
					acc.setAccId(a.getAccId());
					acc.setUserId(a.getUserId());
					acc.setBalance(b);
				
				conn.commit();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	
	}

	public Account addAccount(User u) {
		Account acc = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			//sql command example 
			//insert into artist (name) values ('Beyonce');
			String sql = "insert into accounts (user_id, balance) "
					+ "values (?,?)";
			String[] key= new String[1];
			key[0] = "ACC_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, u.getUser_id());
			ps.setDouble(2, 0);
			int rows = ps.executeUpdate();
			//int id = 0;
			
			if(rows !=0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
				//	id = pk.getInt(1);
					acc.setAccId(pk.getInt(1));
					acc.setUserId(u.getUser_id());
					acc.setBalance(0);
				}
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	@Override
	public ArrayList<Account> getAccounts(User u) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from accounts"
					+ " where USER_ID = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ResultSet rs = ps.executeQuery();
			Account tmp = new Account();
			while(rs.next()) {
				tmp.setAccId(rs.getInt("ACC_ID"));
				tmp.setUserId(rs.getInt("USER_ID"));
				tmp.setBalance(rs.getDouble("BALANCE"));
				accounts.add(tmp);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return accounts;
	}
}


