package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ers.pojos.User;
import com.ers.util.ConnectionFactory;

public class UserDAOImp implements UserDAO
{

	@Override
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> users = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "SELECT * FROM ERS_USERS";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
			{
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setPassWord(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setUserEmail(rs.getString(6));
				temp.setRoleId(rs.getInt(7));
				users.add(temp);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		for (int i = 0; i < users.size(); i++)
		{
			System.out.println(users.get(i).getFirstName());
		}

		return users;
	}

	@Override
	public User addUser(User user)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRSTNAME, USER_LASTNAME, USER_EMAIL, USER_ROLE_ID) VALUES (?,?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "ERS_USERS_ID";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getUserEmail());
			ps.setInt(6, user.getRoleId());

			ps.executeUpdate();

			/*
			 * int rows = ps.executeUpdate();
			 * 
			 * if (rows != 0) { ResultSet rs = ps.getGeneratedKeys(); while (rs.next()) {
			 * user.setUserId(rs.getInt(1)); user.setUserName(rs.getString(2));
			 * user.setPassWord(rs.getString(3)); user.setFirstName(rs.getString(4));
			 * user.setLastName(rs.getString(5)); user.setUserEmail(rs.getString(6));
			 * user.setRoleId(rs.getInt(7)); }
			 * 
			 * conn.commit(); }
			 */

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		if (user.getUserId() != 0)
			return user;
		else
			return null;
	}

	@Override
	public User getUser(User user)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setUserEmail(rs.getString(6));
				user.setRoleId(rs.getInt(7));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		if (user.getUserId() != 0)
			return user;
		else
			return null;
	}

	@Override
	public void deleteUser(int user_id)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "DELETE FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
