package com.rev.project1.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.project1.domain.ReimbStatus;
import com.rev.project1.domain.Reimbursement;
import com.rev.project1.domain.User;
import com.rev.project1.util.ConnectionFactory;

/**
 * Implementation for UserDao interface.
 * @author Shujun Ye
 */
public class ERSDaoImpl implements ERSDao {
	
	/**
	 * Check if the username is unique
	 * @param u user
	 * @return true if the username is unique, false otherwise
	 */
	public boolean uniqueUsername(String username) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE LOWER(ERS_USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Check if the email is unique
	 * @param email user's email
	 * @return true if the email is unique, false otherwise
	 */
	public boolean uniqueEmail(String email) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE LOWER(USER_EMAIL) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Add the user to the database
	 * @param u user
	 * @return true if the user is successfully added; false otherwise.
	 */
	@Override
	public User addUser(String username, String password, String firstname, String lastname, String email, int roleId) {
		User u = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String[] key = {"ERS_USERS_ID"};
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME,"
					+ "USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, username.toLowerCase());
			ps.setString(2, password);
			ps.setString(3, firstname);
			ps.setString(4, lastname);
			ps.setString(5, email.toLowerCase());
			ps.setInt(6, roleId);
			int row = ps.executeUpdate();
			if(row != 0) {
				u = new User(username, password, firstname, lastname, email, roleId);
				ResultSet pk = ps.getGeneratedKeys();
				if(pk.next()) u.setUserId(pk.getInt(1));
				conn.commit();
				return u;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Return the specified user with the given user id
	 * @param userId user id
	 * @return the user
	 */
	@Override
	public User getUserById(int userId) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId); 
			ResultSet info = ps.executeQuery();
			
			if(info.next()) {
				u = new User(info.getString(2), info.getString(3), info.getString(4),
						info.getString(5), info.getString(6), info.getInt(7));
				u.setUserId(info.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	/**
	 * Return the specified user with the given username
	 * @param username user's name
	 * @return the user
	 */
	@Override
	public User getUserByName(String username) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE LOWER(ERS_USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ResultSet info = ps.executeQuery();
			
			if(info.next()) {
				u = new User(info.getString(2), info.getString(3), info.getString(4),
						info.getString(5), info.getString(6), info.getInt(7));
				u.setUserId(info.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	/**
	 * Add the reimbursement to the database
	 * @param r reimbursement
	 * @param u user // need to fix this javadoc
	 * @return reimbursement
	 */
	@Override
	public Reimbursement subReimb(Reimbursement r) {
		double reimbAmount = r.getReimbAmount();
		String reimbDescription = r.getReimbDescription();
		int reimbAuthor = r.getReimbAuthor();
		int reimbStatusId = ReimbStatus.PENDING.getStatusId();
		int reimbTypeId = r.getReimbTypeId();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql;
			PreparedStatement ps;
			String[] keys = {"REIMB_ID", "REIMB_SUBMITTED"};
			if(reimbDescription == null) {
				sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_AUTHOR,"
						+ "REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?, ?, ?, ?)";
				ps = conn.prepareStatement(sql, keys);
				ps.setDouble(1, reimbAmount);
				ps.setInt(2, reimbAuthor);
				ps.setInt(3, reimbStatusId);
				ps.setInt(4, reimbTypeId);
			} else {
				sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION,"
						+ "REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql, keys);
				ps.setDouble(1, reimbAmount);
				ps.setString(2, reimbDescription);
				ps.setInt(3, reimbAuthor);
				ps.setInt(4, reimbStatusId);
				ps.setInt(5, reimbTypeId);
			}
			
			int row = ps.executeUpdate();
			if(row != 0) {
				r = new Reimbursement();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					r.setReimbId(rs.getInt(1));
					r.setReimbSubmitted(rs.getTimestamp(2));
					r.setReimbAmount(reimbAmount);
					r.setReimbDescription(reimbDescription);
					r.setReimbAuthor(reimbAuthor);
					r.setReimbStatusId(reimbStatusId);
					r.setReimbTypeId(reimbTypeId);
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	@Override
	public int getReimbAuthorByReimbId(int reimbId) {
		int reimbAuthorId = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT REIMB_AUTHOR FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbAuthorId = rs.getInt(1);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbAuthorId;
	}

	/**
	 * Return a list of all users' pending reimbursement
	 * @return a list of all users' pending reimbursement
	 */
	@Override
	public List<Reimbursement> getAllPendingReimbs() {
		List<Reimbursement> reimbs = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?";
			ReimbStatus status = ReimbStatus.PENDING;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status.getStatusId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	/**
	 * Return a list of pending reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of pending reimbursement
	 */
	@Override
	public List<Reimbursement> getAllPendingReimbs(int reimbAuthor) {
		List<Reimbursement> reimbs = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID = ?";
			ReimbStatus status = ReimbStatus.PENDING;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbAuthor);
			ps.setInt(2, status.getStatusId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	/**
	 * Return a list of all users' past reimbursement
	 * @return a list of all users' past reimbursement
	 */
	@Override
	public List<Reimbursement> getAllPastReimbs() {
		List<Reimbursement> reimbs = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE NOT REIMB_STATUS_ID = ?";
			ReimbStatus status = ReimbStatus.PENDING;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status.getStatusId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	/**
	 * Return a list of past reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of past reimbursement
	 */
	@Override
	public List<Reimbursement> getAllPastReimbs(int reimbAuthor) {
		List<Reimbursement> reimbs = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ? AND NOT REIMB_STATUS_ID = ?";
			ReimbStatus status = ReimbStatus.PENDING;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbAuthor);
			ps.setInt(2, status.getStatusId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	/**
	 * Return a list of all reimbursement in the system
	 * @return a list of all reimbursement
	 */
	@Override
	public List<Reimbursement> getAllReimbs() {
		List<Reimbursement> reimbs = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT ORDER BY REIMB_STATUS_ID";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	/**
	 * Return a list of reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of reimbursement for a specified user
	 */
	@Override
	public List<Reimbursement> getAllReimbs(int reimbAuthor) {
		List<Reimbursement> reimbs = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ? ORDER BY REIMB_STATUS_ID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbAuthor);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	/**
	 * Update the reimbursement info
	 * @param r reimbursement
	 * @param resolver reimbursement resolver id
	 * @param status reimbursement status id
	 */
	@Override
	public void updateReimb(int reimbId, int resolver, int status) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){			
			CallableStatement cs = conn.prepareCall("{CALL update_reimbursement_status(?, ?, ?)");
		    cs.setInt(1, reimbId);
		    cs.setInt(2, resolver);
		    cs.setInt(3, status);
		    cs.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User updateUser(User u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE ERS_USERS SET ERS_PASSWORD = ?, USER_FIRST_NAME = ?,"
					+ "USER_LAST_NAME = ?, USER_ROLE_ID = ? WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getFirstname());
			ps.setString(3, u.getLastname());
			ps.setInt(4, u.getRoleId());
			ps.setInt(5, u.getUserId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
