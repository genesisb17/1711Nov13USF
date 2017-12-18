package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import connection.ConnectionFactory;
import pojos.Reimbursement;
import pojos.User;
import pojos.UserReimbursement;

public class FileDAO implements DAO {

	public User getUserByUsername(String username) {

		User user = new User();
		final Logger logger = Logger.getLogger(FileDAO.class);

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

			logger.error("Sorry, something wrong!", e);
			/*e.printStackTrace();*/

		}

		return user;
	}
	
	@Override
	public User getUserById(int id) {

		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = " + id;

			Statement ps = conn.createStatement();
			ResultSet info = ps.executeQuery(sql);

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
	public Reimbursement updateStatus(int reimbid, int statusid) {
		
		//Reimbursement reim = new Reimbursement();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "{call UPDATE_STATUS(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimbid);
			cs.setInt(2, statusid);

			int rows = cs.executeUpdate();
			
			if(rows >= 1) {
				//System.out.println("update successful");
			} else {
				System.out.println("Error updating the status");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Reimbursement newReimbursement(int amount, String description, int author, int statusId, int typeId) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "{call INSERT_REIMB(?, ?, ?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, amount);
			cs.setString(2, description);
			cs.setInt(3, author);
			cs.setInt(4, statusId);
			cs.setInt(5, typeId);

			int rows = cs.executeUpdate();
			
			if(rows >= 1) {
				//System.out.println("update successful");
			} else {
				System.out.println("Error adding new reimbursement");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void signup(String username, String password, String firstname, String lastname, String email) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// sql query
			String sql = "{call INSERT_USER(?, ?, ?, ?, ?)}";

			// create the callable statement and execute it
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, firstname);
			cs.setString(4, lastname);
			cs.setString(5, email);

			int rows = cs.executeUpdate();

			// if the user credentials are correct do nothing
			// else, print the error to the console
			if (rows >= 1) {
				
			} else {				
				System.out.println("There was a problem creating the new user");
			}

		} catch (SQLException e) {
			System.out.println("There was a problem creating the new user.");
		}
	
	}

}

