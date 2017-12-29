package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class UserDAOImp implements UserDAO
{

	@Override
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> users = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "SELECT * FROM USERS";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
			{
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassWord(rs.getString(5));
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
			String sql = "INSERT INTO USERS (FIRSTNAME,LASTNAME,USERNAME,PASSWORD) VALUES (?,?,?,?)";
			String[] key = new String[1];
			key[0] = "U_ID";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassWord());

			int rows = ps.executeUpdate();
			if (rows != 0)
			{
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next())
				{
					user.setUserId(rs.getInt(1));
					user.setFirstName(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setUserName(rs.getString(4));
					user.setPassWord(rs.getString(5));
				}

				conn.commit();
			}

		} catch (SQLException e)
		{
			// e.printStackTrace();
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
			String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setPassWord(rs.getString(5));
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
			String sql = "DELETE FROM USERS WHERE U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}