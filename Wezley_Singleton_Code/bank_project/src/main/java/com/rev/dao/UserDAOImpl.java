package com.rev.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public User addUser(User u) {

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);

			String sql = "INSERT INTO users (first_name, last_name, email_address, username, password) "
					+ "VALUES (?, ?, ?, ?, ?)";

			String[] key = new String[6];
			key[0] = "u_id";
			key[1] = "first_name";
			key[2] = "last_name";
			key[3] = "email_address";
			key[4] = "username";
			key[5] = "password";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, u.getFirstName());
			pstmt.setString(2, u.getLastName());
			pstmt.setString(3, u.getEmailAddress());
			pstmt.setString(4, u.getUsername());
			pstmt.setString(5, u.getPassword());

			int rowsUpdated = pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if(rowsUpdated != 0) {

				while(rs.next()) {
					user.setId(rs.getInt(1));
				}

				user.setFirstName(u.getFirstName());
				user.setLastName(u.getLastName());
				user.setEmailAddress(u.getEmailAddress());
				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());

				conn.commit();

			}
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return user;

	}

	@Override
	public User getUserById(int userId) {

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM users WHERE u_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmailAddress(rs.getString(4));
				user.setUsername(rs.getString(5));
				user.setPassword(rs.getString(6));

			}

		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return user;

	}

	@Override
	public User getUserByUsername(String username) {

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmailAddress(rs.getString(4));
				user.setUsername(rs.getString(5));
				user.setPassword(rs.getString(6));

			}
		}
		
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return user;

	}
	
	@Override
	public User getUserByEmailAddress(String emailAddress) {
		
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE email_address = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emailAddress);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmailAddress(rs.getString(4));
				user.setUsername(rs.getString(5));
				user.setPassword(rs.getString(6));

			}
		}
		
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {

		ArrayList<User> users = new ArrayList<User>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM users";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setEmailAddress(rs.getString(4));
				temp.setUsername(rs.getString(5));
				temp.setPassword(rs.getString(6));
				users.add(temp);
				
			}
			
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return users;

	}

	@Override
	public User updateUser(int userId, User user) {

		User updatedUser = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE users SET first_name = ?, last_name = ?, email_address = ?, username = ?, password = ? "
					+ "WHERE u_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmailAddress());
			pstmt.setString(4, user.getUsername());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, userId);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				
				conn.commit();
				updatedUser = getUserById(user.getId());
				
			}
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedUser;

	}


}
