package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ex.util.ConnectionFactory;
import com.rev.pojos.Users;

public class FileDAO implements DAO{

	public Users addUser(Users u) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			connect.setAutoCommit(false);
			String sqlAddUser = "insert into ERS_USERS(ERS_USERNAME, ERS_PASSWORD,"
					+ "USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL) "
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement prepStatement = connect.prepareStatement(sqlAddUser);
			prepStatement.setString(1, u.getUsername());
			prepStatement.setString(2, u.getPassword());
			prepStatement.setString(3, u.getFirstname());
			prepStatement.setString(4, u.getLastname());
			prepStatement.setString(5, u.getEmail());
			
			int rows = prepStatement.executeUpdate();
			
			if(rows != 0) {
				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());
				user.setFirstname(u.getFirstname());
				user.setLastname(u.getLastname());
				user.setEmail(u.getEmail());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Users getUser(String username) {
		
		return null;
	}

	public Users update(Users u) {
		
		Users user = new Users();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			/*******************************************/
			String sqlUpdate = "update ERS_REIMBURSEMENT set REIMB_AMOUNT = ? where user_id = ?";
			PreparedStatement prepStatement = conn.prepareStatement(sqlUpdate);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
