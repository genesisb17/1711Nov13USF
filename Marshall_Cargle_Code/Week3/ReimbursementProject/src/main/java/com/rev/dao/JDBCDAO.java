package com.rev.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.rev.pojos.Ticket;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class JDBCDAO implements DAO {

	@Override
	public User addUser(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ERS_Users (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)"
					+ "values ((?), (?), (?), (?), (?), '1')";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("CONSTRAINT");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//User user = getUser(u.getEmail(), u.getPassword());
		//return u;
		System.out.println("NOT");
		return u;
	}

	@Override
	public Ticket addTicket(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String Email, String password) {
		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_USERS where USER_EMAIL=? and ERS_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Email);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				user.setUser_ID(info.getInt(1));
				user.setUsername(info.getString(2));
				user.setPassword(info.getString(3));
				user.setFirstName(info.getString(4));
				user.setLastName(info.getString(5));
				user.setEmail(info.getString(6));
				user.setRole(info.getInt(7));
				System.out.println("test1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user.getEmail() == null) {
			System.out.println("test");
			return null;
		}
		return user;
	}

	@Override
	public Ticket getTicket(int ticket_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticket> getTickets(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User setEmail(User u, String Email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_USERS USER_EMAIL = ? where ERS_USERS_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Email);
			ps.setInt(2, u.getUser_ID());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
