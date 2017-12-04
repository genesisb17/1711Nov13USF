package dao;

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

}
