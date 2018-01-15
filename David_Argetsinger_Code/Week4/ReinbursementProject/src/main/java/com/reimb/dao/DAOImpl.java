package com.reimb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.reimb.pojos.User;
import com.reimb.util.ConnectionFactory;

public class DAOImpl implements DAO {

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByEmail(String email){
		User use = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_USERS where USER_EMAIL = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(4));
				use.setUsername((info.getString(2)));
				use.setLastname(info.getString(5));
				use.setPassword((info.getString(3)));
				use.setEmail(info.getString(6));
				use.setRole(info.getInt(7));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return use;
	}
	
	
	public User updateAccount(User user){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE ERS_USERS SET USER_FIRST_NAME=?,USER_LAST_NAME=?,ERS_PASSWORD=?,USER_EMAIL=? WHERE ERS_Username=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());	
			preparedStatement.setString(2, user.getLastname());	
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getUsername());
			System.out.println("attempting to ssysout prepstate in updateaccount");
			System.out.println(preparedStatement);
			System.out.println(user);
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			if (rows != 0) {
				conn.commit();
				return user;
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println("update not effective. check frontend checks . ");
		return user;
}
		
	
	public User getUserByUname(String username) {
		User use = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_USERS where ERS_Username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(4));
				use.setUsername((info.getString(2)));
				use.setLastname(info.getString(5));
				use.setPassword((info.getString(3)));
				use.setEmail(info.getString(6));
				use.setRole(info.getInt(7));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return use;
	}

	public User doLogin(String usern, String passw) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	public boolean addUser(String name, String Lastname, String username, String password,String email, int role) {
		//User use = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS (USER_FIRST_NAME,USER_LAST_NAME,ERS_USERNAME,ERS_PASSWORD,USER_EMAIL,USER_ROLE_ID) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2,Lastname);
			preparedStatement.setString(3,username);
			preparedStatement.setString(4,password);
			preparedStatement.setString(5,email);
			preparedStatement.setInt(6,role);

			//					String[] key = new String[5];
			//					key[0] = "U_ID";
			//					
			//					PreparedStatement ps = conn.prepareStatement(sql, key); 
			//					ps.setString(1, name);
			//					ps.setString(2, Lastname);
			//					ps.setString(3, username);
			//					ps.setString(4, password);
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			//					int id = 0;
			if (rows != 0) {
				//						ResultSet pk = preparedStatement.getGeneratedKeys(); // returns a id key, (and value ) 
				//						while (pk.next()) {
				//							use.setId(pk.getInt(1)); // returns auto incremented number ! 
				//						} // using just execute.? will work with key 
				//						use.setName(name);
				//						use.setLastname(Lastname);
				//						use.setUsername(username);
				//						use.setPassword(password);
				conn.commit();
				return true;

			}
		} catch(SQLIntegrityConstraintViolationException e){
			System.out.println("That username already exists. Please try again.");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}

