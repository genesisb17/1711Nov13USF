package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;
import com.revature.types.UserRoles;
import com.revature.util.ConnectionFactory;

public class ERSDatabaseDAO implements ERSDAO {
	
	// Database column name constants
	static final String DB_KEY_USERID = "ERS_USERS_ID";
	static final String DB_KEY_USERNAME = "ERS_USERNAME";
	static final String DB_KEY_PASSWORD = "ERS_PASSWORD";
	static final String DB_KEY_FIRSTNAME = "USER_FIRST_NAME";
	static final String DB_KEY_LASTNAME = "USER_LAST_NAME";
	static final String DB_KEY_EMAIL = "USER_EMAIL";
	static final String DB_KEY_ROLEID = "USER_ROLE_ID";
	static final String DB_KEY_REIMBID = "REIMB_ID";
	static final String DB_KEY_AMOUNT = "REIMB_AMOUNT";
	static final String DB_KEY_SUBMITTED = "REIMB_SUBMITTED";
	static final String DB_KEY_RESOLVED = "REIMB_RESOLVED";
	static final String DB_KEY_DESCRIPTION = "REIMB_DESCRIPTION";
	static final String DB_KEY_RECEIPT = "REIMB_RECEIPT";
	static final String DB_KEY_AUTHOR = "REIMB_AUTHOR";
	static final String DB_KEY_RESOLVER = "REIMB_RESOLVER";
	static final String DB_KEY_STATUSID = "REIMB_STATUS_ID";
	static final String DB_KEY_TYPEID = "REIMB_TYPE_ID";
	static final String DB_KEY_ROLE = "USER_ROLE";

	@Override
	public Users getUserByUsername(String username) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String selectUsers = "select * from ers_users where ers_username = ?";
			String selectRole = "select * from ers_user_roles where ers_user_role_id = ?";
			PreparedStatement su = conn.prepareStatement(selectUsers);
			PreparedStatement sr = conn.prepareStatement(selectRole);
			su.setString(1, username);
			ResultSet userSet = su.executeQuery();
			ResultSet roleSet = null;
			
			while (userSet.next()) {
				u = new Users();
				u.setUserId(userSet.getInt(DB_KEY_USERID));
				u.setUsername(userSet.getString(DB_KEY_USERNAME));
				u.setFirstName(userSet.getString(DB_KEY_FIRSTNAME));
				u.setLastName(userSet.getString(DB_KEY_LASTNAME));
				u.setEmail(userSet.getString(DB_KEY_EMAIL));
				
				sr.setInt(1, userSet.getInt(DB_KEY_ROLEID));
				roleSet = sr.executeQuery();
			}
			
			if (u != null) {
				UserRoles role = UserRoles.valueOf(roleSet.getString(DB_KEY_ROLE));
				u.setRole(role);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users addUser(Users newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getPastTickets(Users employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getTicket(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllTickets(Users manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement addTicket(Reimbursement newTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement resolveTicket(int reimbId, ReimbursementStatus status, int resolverId) {
		// TODO Auto-generated method stub
		return null;
	}

}
