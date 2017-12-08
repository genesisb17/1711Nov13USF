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

			PreparedStatement ps = connect.prepareStatement(sqlAddUser);
			//PreparedStatement insertReimb = connect.prepareStatement(sqlAddReimb);
			System.out.println("in sql");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserRoleId());
			System.out.println(u);
			System.out.println("in sql2");
			int row = ps.executeUpdate();
			//connect.commit();
			if(row != 0) {
				connect.commit();
				System.out.println("in sql3");
				return user;
			}
//			if(rows != 0) {
//				ResultSet pk = ps.getGeneratedKeys();
//				while(pk.next()) {
//					u.setId(pk.getInt(1));
//				}
//				user.setFirstname(u.getFirstname());
//				user.setLastname(u.getLastname());
//				user.setUsername(u.getUsername());
//				user.setPassword(u.getPassword());
//				user.setBalance(u.getBalance());
//				conn.commit();
//				
//			}
//			if(rows != 0) {
//				ResultSet rs = ps.getGeneratedKeys();
//				while(rs.next()) {
//					u.setUsers_id(rs.getInt(1));
//				}
//				user.setUsername(u.getUsername());
//				user.setPassword(u.getPassword());
//				user.setFirstname(u.getFirstname());
//				user.setLastname(u.getLastname());
//				user.setEmail(u.getEmail());
//				user.setUserRoleId(u.getUserRoleId());
//				connect.commit();
//				System.out.println("after commit");
//				connect.close();
//			}
			
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

	public Users update(Users u, Reimbursement reimb) {
		
//		UPDATE ERS_REIMBURSEMENT
//		SET REIMB_RESOLVER = 2, REIMB_STATUS_ID = 2
//		WHERE REIMB_ID = 2;
		
		Users user = new Users();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			/*******************************************/
			String sqlUpdate = "update ERS_REIMBURSEMENT set REIMB_RESOLVER = ?, 				REIMB_STATUS_ID = ? where REIMB_ID = ?";
			PreparedStatement prepStatement = connect.prepareStatement(sqlUpdate);
			prepStatement.setInt(1, u.getUsers_id());
			prepStatement.setInt(2, reimb.getStatus_id());
			prepStatement.setInt(3, reimb.getReimb_id());
			prepStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
