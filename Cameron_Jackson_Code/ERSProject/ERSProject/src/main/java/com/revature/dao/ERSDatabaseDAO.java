package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

			while (userSet.next()) { // make sure result set isn't empty
				// add to user object
				u = new Users();
				u.setUserId(userSet.getInt(DB_KEY_USERID));
				u.setUsername(userSet.getString(DB_KEY_USERNAME));
				u.setFirstName(userSet.getString(DB_KEY_FIRSTNAME));
				u.setLastName(userSet.getString(DB_KEY_LASTNAME));
				u.setEmail(userSet.getString(DB_KEY_EMAIL));
				u.setRoleId(userSet.getInt(DB_KEY_ROLEID));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users getUserById(int userId) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String selectUsers = "select * from ers_users where ers_users_id = ?";
			String selectRole = "select * from ers_user_roles where ers_user_role_id = ?";
			PreparedStatement su = conn.prepareStatement(selectUsers);
			PreparedStatement sr = conn.prepareStatement(selectRole);
			su.setInt(1, userId);
			ResultSet userSet = su.executeQuery();
			ResultSet roleSet = null;

			while (userSet.next()) {
				u = new Users();
				u.setUserId(userSet.getInt(DB_KEY_USERID));
				u.setUsername(userSet.getString(DB_KEY_USERNAME));
				u.setFirstName(userSet.getString(DB_KEY_FIRSTNAME));
				u.setLastName(userSet.getString(DB_KEY_LASTNAME));
				u.setEmail(userSet.getString(DB_KEY_EMAIL));
				u.setRoleId(userSet.getInt(DB_KEY_ROLEID));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public UserRoles getRole(int roleId) {
		UserRoles role = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_user_roles where ers_user_role_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				role = UserRoles.valueOf(rs.getString(DB_KEY_ROLE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public ArrayList<Users> getAllUsers() {
		ArrayList<Users> users = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String selectUsers = "select * from ers_users";
			Statement su = conn.createStatement();
			ResultSet rs = su.executeQuery(selectUsers);

			while (rs.next()) {
				Users u = new Users();
				u.setUserId(rs.getInt(DB_KEY_USERID));
				u.setUsername(rs.getString(DB_KEY_USERNAME));
				u.setFirstName(rs.getString(DB_KEY_FIRSTNAME));
				u.setLastName(rs.getString(DB_KEY_LASTNAME));
				u.setEmail(rs.getString(DB_KEY_EMAIL));
				u.setRoleId(rs.getInt(DB_KEY_ROLEID));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public Users addUser(Users newUser, String password) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME,\r\n" + 
					"USER_EMAIL, USER_ROLE_ID)\r\n" + 
					"VALUES (?,?,?,?,?,?)";
			String[] keys = {DB_KEY_USERID};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, newUser.getUsername());
			ps.setString(2, password);
			ps.setString(3, newUser.getFirstName());
			ps.setString(4, newUser.getLastName());
			ps.setString(5, newUser.getEmail());
			ps.setInt(6, newUser.getRoleId());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					u = new Users();
					u.setUserId(rs.getInt(1));
					u.setUsername(newUser.getUsername());
					u.setFirstName(newUser.getFirstName());
					u.setLastName(newUser.getLastName());
					u.setEmail(newUser.getEmail());
					u.setRoleId(newUser.getRoleId());
				}
				conn.commit();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
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
