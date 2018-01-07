package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.util.ConnectionFactory;
import com.rev.pojos.User;

public class DAOImpl implements DAO {

	@Override
	public User addUser(User u) {
		String fn = u.getFirstname();
		String ln = u.getLastname();
		String un = u.getUsername();
		String pw = u.getPassword();
		double balance = u.getBalance();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			// Insert the given info into the USERS table
			String sql1 = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD)"
					+ "VALUES (?, ?, ?, ?)";
			String[] key1 = new String[1];
			key1[0] = "U_ID";

			PreparedStatement ps1 = conn.prepareStatement(sql1, key1);
			ps1.setString(1, fn);
			ps1.setString(2, ln);
			ps1.setString(3, un);
			ps1.setString(4, pw);
			int rows1 = ps1.executeUpdate();
			if (rows1 != 0) {
				ResultSet pk1 = ps1.getGeneratedKeys();
				if (pk1.next()) {
					u.setId(pk1.getInt(1));
				}
				conn.commit();
			}
			
			// Insert the given info into the ACCOUNT table
			int id = u.getId();
			System.out.println("acc id " + u.getId());
			String sql2 = "INSERT INTO ACCOUNT (USER_ID, BALANCE)"
					+ "VALUES (?, ?)";
			String[] key2 = new String[1];
			key2[0] = "ACC_ID";
			
			PreparedStatement ps2 = conn.prepareStatement(sql2, key2);
			ps2.setInt(1, id);
			ps2.setDouble(2, balance);
			int rows2 = ps2.executeUpdate();
			if (rows2 != 0) {
//				ResultSet pk2 = ps2.getGeneratedKeys();
//				while (pk2.next()) {
//					u.setId(pk2.getInt(1));
//				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User getUser(String username) {
		username = username.toLowerCase();
		User u = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM USERS, ACCOUNT WHERE LOWER(USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u.setId(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
				u.setBalance(info.getDouble(8));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS, ACCOUNT WHERE USERS.U_ID = ACCOUNT.USER_ID";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setFirstname(rs.getString(2));
				temp.setLastname(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPassword(rs.getString(5));
				temp.setBalance(rs.getDouble(8));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public double depositMoney(User u, double money) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			int userId = u.getId();
			double balance = u.getBalance() + money;
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, userId);
			u.setBalance(balance);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u.getBalance();
	}

	@Override
	public double withdrawMoney(User u, double money) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			int userId = u.getId();
			double balance = u.getBalance() - money;
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, userId);
			u.setBalance(balance);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u.getBalance();
	}
}
