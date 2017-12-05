package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
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
				user.setFirstName(info.getString("USER_FIRST_NAME"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return user;
	}

	@Override
	public User login(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			int rows = ps.executeUpdate();

			if (rows >= 1) {

				System.out.println("Welcome");

			} else {

				System.out.println("There was a problem. Please try again later.");

			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem with the login. Please try again later.");

		}
		return null;
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

}
