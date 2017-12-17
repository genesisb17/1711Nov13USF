package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.util.ConnectionFactory;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementNames;
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
				user.setEmail(u.getEmail());
				user.setFirstname(u.getFirstname());
				user.setLastname(u.getLastname());
				user.setPassword(u.getPassword());
				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());	
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

	/*
	 * function that updates the status of the reimbursement;
	 * ex) from pending(1) to (2)approved or (3) denied
	 * based on the reimb_id and who resolved it shown as the ID
	 */
	public void update(int user_id, int status_id, int reimb_id) {

		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			
			connect.setAutoCommit(false);

			String sqlUpdate = "update ERS_REIMBURSEMENT set REIMB_RESOLVER = ?, "
					+ "REIMB_STATUS_ID = ? where REIMB_ID = ?";
			PreparedStatement prepStatement = connect.prepareStatement(sqlUpdate);
			prepStatement.setInt(1, user_id);
			prepStatement.setInt(2, status_id);
			prepStatement.setInt(3, reimb_id);
			prepStatement.executeUpdate();
			
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * function to show the table for the manager, grab all the information from
	 * reimbursement table and join with user table (so it could get the firstname
	 * and lastname of the author who submitted the reimbursement
	 */
	
	public ArrayList<ReimbursementNames> getTable(){
		ArrayList<ReimbursementNames> arr = new ArrayList<ReimbursementNames>();
		Users user = new Users();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "select reimb.reimb_id, reimb.reimb_amount, reimb.reimb_submitted,"
					+ " reimb.reimb_resolved, reimb.reimb_description, reimb.reimb_author,"
					+ " reimb.reimb_resolver, reimb.reimb_status_id, reimb.reimb_type_id,"
					+ " u.user_first_name, u.user_last_name from ers_reimbursement reimb "
					+ "inner join ers_users u on reimb.reimb_author = u.ers_users_id";
			// statement to select firstname and lastname from reimbursement author id
			
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery(sql);

			while(rs.next()) {
				ReimbursementNames reimb = new ReimbursementNames();
				reimb.setReimb_id(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getTimestamp(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setAuthor(rs.getInt(6));
				reimb.setResolver(rs.getInt(7));
				reimb.setStatus_id(rs.getInt(8));
				reimb.setType_id(rs.getInt(9));
				reimb.setFirst_name(rs.getString(10));
				reimb.setLast_name(rs.getString(11));
				arr.add(reimb);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
