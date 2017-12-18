package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> getUsers() {

		List<User> usersList = new ArrayList<User>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM ERS_Users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstname(rs.getString(4));
				temp.setLastname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRoleId(rs.getInt(7));
				usersList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (User user : usersList)
			System.out.println(user.getFirstname());

		return usersList;
	}

	@Override
	public User getUser(int id) {
		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_Users WHERE ERS_Users_Id = " + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstname(rs.getString(4));
				user.setLastname(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRoleId(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (user.getUserId() == 0) ? null : user;
	}

	@Override
	public User getUser(String username) {

		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_Users WHERE ERS_Username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstname(rs.getString(4));
				user.setLastname(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRoleId(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (user.getUserId() == 0) ? null : user;
	}

	@Override
	public int addUser(String fn, String ln, String un, String pw, String em, int roleId) {

		int userId = -1;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Ers_Users (ERS_Username, ERS_Password, User_First_Name, User_Last_Name, User_Email, User_Role_Id) VALUES (?,?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "ERS_Users_Id";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setString(1, un);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setString(5, em);
			ps.setInt(6, roleId);

			int rows = ps.executeUpdate();

			if (rows != 0) {
				System.out.println("insertion worked rows != 0");
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					userId = rs.getInt(1);
				}

				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userId;
	}

	@Override
	public void deleteUser(int id) {
	}

}
