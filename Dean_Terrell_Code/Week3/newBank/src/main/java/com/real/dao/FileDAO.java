package com.real.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.real.pojos.User;
import com.real.util.ConnectionFactory;

public class FileDAO implements DAO{
	
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ROLE_ID) VALUES(?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getuName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getfName());
			ps.setString(4, u.getlName());
			ps.setInt(5, u.getRole());
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys(); // only retrieve auto-generated keys
			pk.next();
			int id = pk.getInt(1);
			
			/*
			sql = "INSERT INTO ACCOUNTS(USER_ID, BALANCE) VALUES (?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setDouble(2, 0);
			ps.executeUpdate();*/

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public User getUser(String username) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // Goes by order of question marks
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u.setId(info.getInt(1));
				u.setuName(info.getString(2));
				u.setPassword(info.getString(3));
				u.setfName(info.getString(4));
				u.setlName(info.getString(5));
				u.setRole(info.getInt(6));
			}
			
			/*sql = "select balance from accounts where user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			info = ps.executeQuery();
			info.next();
			u.setBalance(info.getDouble(1));*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void updateBalance(User u, double newB) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE accounts set balance = ? where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newB);
			ps.setInt(2, u.getId());
			ps.executeUpdate();
	
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
