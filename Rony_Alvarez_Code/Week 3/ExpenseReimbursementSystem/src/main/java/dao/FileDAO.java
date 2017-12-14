package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionFactory;
import pojos.Reimbursement;
import pojos.User;
import pojos.UserReimbursement;

public class FileDAO implements DAO {

	public User getUserByUsername(String username) {

		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			while (info.next()) {

				user.setId(info.getInt("ERS_USERS_ID"));
				user.setUsername(info.getString("ERS_USERNAME"));
				user.setFirstName(info.getString("USER_FIRST_NAME"));
				user.setLastName(info.getString("USER_LAST_NAME"));
				user.setEmail(info.getString("USER_EMAIL"));
				user.setRole(info.getInt("USER_ROLE_ID"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return user;
	}

	@Override
	public int login(String username, String password) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// set auto commit to false
			conn.setAutoCommit(false);

			// sql query
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";

			// create the prepared statement and execute it
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			int rows = ps.executeUpdate();

			// if the user credentials are correct return 1
			// else, return 0
			if (rows >= 1) {

				return 1;

			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem with the login. Please try again later.");

		}

		return 0;

	}

	@Override
	public User signup(User u) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "{call INSERT_NEW_USER(?, ?, ?, ?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getFirstName());
			cs.setString(4, u.getLastName());
			cs.setString(5, u.getEmail());
			cs.setInt(6, u.getRole());

			int rows = cs.executeUpdate();

			if (rows >= 1) {

				System.out.println("Account created successfully!");

			} else {

				System.out.println("There was a problem creating the new account. Please try again later.");

			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem creating the new account. Please try again later.");

		}

		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements(String username) {
		
		ArrayList<Reimbursement> reimArray = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT REIMB.REIMB_ID, \r\n" + 
					"  USR.ERS_USERNAME,\r\n" + 
					"  REIMB.REIMB_AMOUNT,\r\n" + 
					"  REIMB.REIMB_SUBMITTED, \r\n" + 
					"  REIMB.REIMB_DESCRIPTION, \r\n" + 
					"  TYP.REIMB_TYPE,\r\n" + 
					"  STAT.REIMB_STATUS\r\n" + 
					"FROM ERS_REIMBURSEMENT REIMB\r\n" + 
					"INNER JOIN ERS_REIMBURSEMENT_STATUS STAT\r\n" + 
					"ON REIMB.REIMB_STATUS_ID = STAT.REIMB_STATUS_ID \r\n" + 
					"INNER JOIN ERS_REIMBURSEMENT_TYPE TYP\r\n" + 
					"ON REIMB.REIMB_TYPE_ID = TYP.REIMB_TYPE_ID\r\n" + 
					"INNER JOIN ERS_USERS USR\r\n" + 
					"ON REIMB.REIMB_AUTHOR = USR.ERS_USERS_ID";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet info = ps.executeQuery();

			while (info.next()) {
				
				Reimbursement reim = new Reimbursement();

				reim.setId(info.getInt("REIMB_ID"));
				reim.setUsername(info.getString("ERS_USERNAME"));
				reim.setAmount(info.getInt("REIMB_AMOUNT"));
				reim.setSubmitted(info.getTimestamp("REIMB_SUBMITTED"));
				reim.setDescription(info.getString("REIMB_DESCRIPTION"));
				reim.setType(info.getString("REIMB_TYPE"));
				reim.setStatus(info.getString("REIMB_STATUS"));
				
				reimArray.add(reim);	

			}
			
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return reimArray;
	}

	@Override
	public ArrayList<UserReimbursement> getUserReimbursements(int id) {
		
		ArrayList<UserReimbursement> reimArray = new ArrayList<UserReimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT REIMB.REIMB_ID, \r\n" + 
					"  REIMB.REIMB_AMOUNT,\r\n" + 
					"  REIMB.REIMB_SUBMITTED, \r\n" + 
					"  REIMB.REIMB_DESCRIPTION, \r\n" + 
					"  TYP.REIMB_TYPE,\r\n" + 
					"  STAT.REIMB_STATUS\r\n" + 
					"FROM ERS_REIMBURSEMENT REIMB\r\n" + 
					"INNER JOIN ERS_REIMBURSEMENT_STATUS STAT\r\n" + 
					"ON REIMB.REIMB_STATUS_ID = STAT.REIMB_STATUS_ID \r\n" + 
					"INNER JOIN ERS_REIMBURSEMENT_TYPE TYP\r\n" + 
					"ON REIMB.REIMB_TYPE_ID = TYP.REIMB_TYPE_ID\r\n" + 
					"WHERE REIMB.REIMB_AUTHOR = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				
				UserReimbursement reim = new UserReimbursement();

				reim.setId(info.getInt("REIMB_ID"));
				reim.setAmount(info.getInt("REIMB_AMOUNT"));
				reim.setSubmitted(info.getTimestamp("REIMB_SUBMITTED"));
				reim.setDescription(info.getString("REIMB_DESCRIPTION"));
				reim.setType(info.getString("REIMB_TYPE"));
				reim.setStatus(info.getString("REIMB_STATUS"));
				
				reimArray.add(reim);

			}
			
		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return reimArray;
	}

	@Override
	public Reimbursement updateStatus(int id) {
		
		Reimbursement reim = new Reimbursement();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = " + id + " WHERE REIMB_ID = 123464;\r\n" + 
					"commit;";

			Statement stmt = conn.createStatement();

			int rows = stmt.executeUpdate(sql);
			
			if(rows >= 1) {
				System.out.println("update successful");
			} else {
				System.out.println("nope");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return null;
	}

}

