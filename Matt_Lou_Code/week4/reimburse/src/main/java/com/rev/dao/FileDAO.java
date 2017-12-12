package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			
			PreparedStatement ps = connect.prepareStatement(sqlAddUser);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserRoleId());

			int row = ps.executeUpdate();
			if(row != 0) {
				connect.commit();
				System.out.println("in sql3");
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
	
	public ArrayList<Reimbursement> getTable(){
		ArrayList<Reimbursement> arr = new ArrayList<Reimbursement>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "select reimb_amount, reimb_submitted, reimb_resolved, "
					+ "reimb_description, reimb_author, reimb_resolver, " + 
					"reimb_status_id, reimb_type_id from ers_reimbursement";
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setAmount(rs.getDouble(1));
				reimb.setSubmitted(rs.getTimestamp(2));
				reimb.setResolved(rs.getTimestamp(3));
				reimb.setDescription(rs.getString(4));
				reimb.setAuthor(rs.getInt(5));
				reimb.setResolver(rs.getInt(6));
				reimb.setStatus_id(rs.getInt(7));
				reimb.setType_id(rs.getInt(8));
				arr.add(reimb);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
