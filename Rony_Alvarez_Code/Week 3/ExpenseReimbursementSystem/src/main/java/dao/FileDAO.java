package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionFactory;
import pojos.Reimbursement;
import pojos.User;

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
		Reimbursement reim = new Reimbursement();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM ERS_REIMBURSEMENT";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet info = ps.executeQuery();

			while (info.next()) {

				reim.setId(info.getInt("REIMB_ID"));
				reim.setAmount(info.getInt("REIMB_AMOUNT"));
				reim.setSubmitted(info.getTimestamp("REIMB_SUBMITTED"));
				reim.setResolved(info.getTimestamp("REIMB_RESOLVED"));
				reim.setDescription(info.getString("REIMB_DESCRIPTION"));
				reim.setReceipt(info.getBlob("REIMB_RECEIPT"));
				reim.setAuthor(info.getInt("REIMB_AUTHOR"));
				reim.setResolver(info.getInt("REIMB_RESOLVER"));
				reim.setStatusId(info.getInt("REIMB_STATUS_ID"));
				reim.setTypeId(info.getInt("REIMB_TYPE_ID"));
				
				reimArray.add(reim);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return reimArray;
	}

}
