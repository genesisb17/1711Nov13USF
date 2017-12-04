package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.util.ConnectionFactory;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.Users;

public class FileDAO implements DAO{

	public Users addUser(Users u) {
		Users user = new Users();
//		Reimbursement reimburse = new Reimbursement();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			connect.setAutoCommit(false);
			String sqlAddUser = "insert into ERS_USERS(ERS_USERNAME, ERS_PASSWORD,"
					+ "USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			
//			String sqlAddReimb = "insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, "
//					+ "REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, "
//					+ "REIMB AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID "
//					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement insertUser = connect.prepareStatement(sqlAddUser);
			//PreparedStatement insertReimb = connect.prepareStatement(sqlAddReimb);
			insertUser.setString(1, u.getUsername());
			insertUser.setString(2, u.getPassword());
			insertUser.setString(3, u.getFirstname());
			insertUser.setString(4, u.getLastname());
			insertUser.setString(5, u.getEmail());
			insertUser.setInt(6, u.getUserRoleId());
			
			
			int rows = insertUser.executeUpdate();
			
			if(rows != 0) {
				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());
				user.setFirstname(u.getFirstname());
				user.setLastname(u.getLastname());
				user.setEmail(u.getEmail());
				user.setUserRoleId(u.getUserRoleId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Users getUser(String username) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ERS_USERS where ERS_USERNAME = ?";
			PreparedStatement prepStatement = connect.prepareStatement(sql);
			
			prepStatement.setString(1, username);
			
			ResultSet result = prepStatement.executeQuery();
			
			while(result.next()) {
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setFirstname(result.getString(4));
				user.setLastname(result.getString(5));
				user.setEmail(result.getString(6));
				user.setUserRoleId(result.getInt(7));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Users update(Users u) {
		
//		UPDATE ERS_REIMBURSEMENT
//		SET REIMB_RESOLVER = 2, REIMB_STATUS_ID = 2
//		WHERE REIMB_ID = 2;
		
		Users user = new Users();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			/*******************************************/
			String sqlUpdate = "update ERS_REIMBURSEMENT set REIMB_RESOLVER = ?, 				REIMB_STATUS_ID = ? where REIMB_ID = ?";
			PreparedStatement prepStatement = connect.prepareStatement(sqlUpdate);
			prepStatement.setInt(1, u.getUsers_id());
			prepStatement.setInt(2, reimburse.);
			prepStatement.setInt(3, );
			prepStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
