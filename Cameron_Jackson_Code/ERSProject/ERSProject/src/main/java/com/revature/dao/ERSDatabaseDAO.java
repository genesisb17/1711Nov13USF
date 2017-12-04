package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;
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
	static final String DB_KEY_STATUS = "REIMB_STATUS";
	static final String DB_KEY_TYPEID = "REIMB_TYPE_ID";
	static final String DB_KEY_TYPE = "REIMB_TYPE";
	static final String DB_KEY_ROLE = "USER_ROLE";


	@Override
	public Users getUserByUsername(String username) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String selectUsers = "select * from ers_users where ers_username = ?";
			PreparedStatement su = conn.prepareStatement(selectUsers);
			su.setString(1, username);
			ResultSet userSet = su.executeQuery();

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
			PreparedStatement su = conn.prepareStatement(selectUsers);
			su.setInt(1, userId);
			ResultSet userSet = su.executeQuery();

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
	public Users addUser(Users newUser) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME,\r\n" + 
					"USER_EMAIL, USER_ROLE_ID)\r\n" + 
					"VALUES (?,?,?,?,?,?)";
			String[] keys = {DB_KEY_USERID};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, newUser.getUsername());
			ps.setString(2, newUser.getPassword());
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
				}
				conn.commit();
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public String findUsername(String username) {
		String ersUsername = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select ers_username from ers_users where ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ersUsername = rs.getString(DB_KEY_USERNAME);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ersUsername;
	}

	@Override
	public String findPassword(String username) {
		String password = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select ers_password from ers_users where ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				password = rs.getString(DB_KEY_PASSWORD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	@Override
	public Reimbursement getTicket(int reimbId) {
		Reimbursement reimb = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setReimbId(reimbId);
				reimb.setAmount(rs.getDouble(DB_KEY_AMOUNT));
				reimb.setSubmitted(rs.getString(DB_KEY_SUBMITTED));
				reimb.setResolved(rs.getString(DB_KEY_RESOLVED));
				reimb.setDescription(rs.getString(DB_KEY_DESCRIPTION));
				reimb.setReceipt(rs.getBlob(DB_KEY_RECEIPT));
				reimb.setAuthor(rs.getInt(DB_KEY_AUTHOR));
				reimb.setResolver(rs.getInt(DB_KEY_RESOLVER));
				reimb.setStatusId(rs.getInt(DB_KEY_STATUSID));
				reimb.setTypeId(rs.getInt(DB_KEY_TYPEID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimb;
	}

	@Override
	public ArrayList<Reimbursement> getPastTickets(int employeeId) {
		ArrayList<Reimbursement> tickets = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement where reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb = new Reimbursement();
				reimb.setReimbId(rs.getInt(DB_KEY_REIMBID));
				reimb.setAmount(rs.getDouble(DB_KEY_AMOUNT));
				reimb.setSubmitted(rs.getString(DB_KEY_SUBMITTED));
				reimb.setResolved(rs.getString(DB_KEY_RESOLVED));
				reimb.setDescription(rs.getString(DB_KEY_DESCRIPTION));
				reimb.setReceipt(rs.getBlob(DB_KEY_RECEIPT));
				reimb.setAuthor(rs.getInt(DB_KEY_AUTHOR));
				reimb.setResolver(rs.getInt(DB_KEY_RESOLVER));
				reimb.setStatusId(rs.getInt(DB_KEY_STATUSID));
				reimb.setTypeId(rs.getInt(DB_KEY_TYPEID));
				tickets.add(reimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public ArrayList<Reimbursement> getAllTickets() {
		ArrayList<Reimbursement> tickets = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb = new Reimbursement();
				reimb.setReimbId(rs.getInt(DB_KEY_REIMBID));
				reimb.setAmount(rs.getDouble(DB_KEY_AMOUNT));
				reimb.setSubmitted(rs.getString(DB_KEY_SUBMITTED));
				reimb.setResolved(rs.getString(DB_KEY_RESOLVED));
				reimb.setDescription(rs.getString(DB_KEY_DESCRIPTION));
				reimb.setReceipt(rs.getBlob(DB_KEY_RECEIPT));
				reimb.setAuthor(rs.getInt(DB_KEY_AUTHOR));
				reimb.setResolver(rs.getInt(DB_KEY_RESOLVER));
				reimb.setStatusId(rs.getInt(DB_KEY_STATUSID));
				reimb.setTypeId(rs.getInt(DB_KEY_TYPEID));
				tickets.add(reimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public Reimbursement addTicket(Reimbursement newTicket) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_RECEIPT,\r\n" + 
					"REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?,?,?,?,?,?)";
			String[] keys = {DB_KEY_REIMBID};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, newTicket.getAmount());
			ps.setString(2, newTicket.getDescription());
			ps.setBlob(3, newTicket.getReceipt());
			ps.setInt(4, newTicket.getAuthor());
			ps.setInt(5, newTicket.getStatusId());
			ps.setInt(6, newTicket.getTypeId());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					
					newTicket.setReimbId(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newTicket;
	}

	@Override
	public Reimbursement resolveTicket(int reimbId, ReimbursementStatus status, int resolverId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "{CALL RESOLVE_REIMBURSEMENT(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimbId);
			cs.setInt(2, status.ordinal()+1);
			cs.setInt(3, resolverId);
			cs.executeUpdate();
			conn.commit();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getTicket(reimbId);
	}

	@Override
	public ReimbursementStatus getStatus(int statusId) {
		ReimbursementStatus status = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select reimb_status from ers_reimbursement_status where REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				status = ReimbursementStatus.valueOf(rs.getString(DB_KEY_STATUS));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ReimbursementType getType(int typeId) {
		ReimbursementType type = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select reimb_type from ers_reimbursement_type where reimb_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				type = ReimbursementType.valueOf(rs.getString(DB_KEY_TYPE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

}
