package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.SpecTicket;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class JDBCDAO implements DAO {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss");
	@Override
	public User addUser(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ERS_Users (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)"
					+ "values ((?), (?), (?), (?), (?), '0')";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLIntegrityConstraintViolationException e) {
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("test");
		return u;
	}

	@Override
	public Ticket addTicket(Ticket t) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMD_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) \r\n"
					+ "values ((?), (?), (?), (?), (?),(?))";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, 50);
			System.out.println(sdf.format(t.getSubmitted()).toString());
			ps.setString(2, sdf.format(t.getSubmitted()));
			ps.setString(3, t.getDescription());
			ps.setInt(4, 21);
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user.getEmail() == null) {
			return null;
		}
		return user;
	}

	@Override
	public List<SpecTicket> getTickets() {
		List<SpecTicket> tickets = new ArrayList<>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "{call get_all_tickets(?)}";
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				tickets.add(new SpecTicket(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDouble(5), rs.getTimestamp(6), 
						rs.getTimestamp(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public User setAccount(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_USERS USER_EMAIL = ? where ERS_USERS_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2, u.getUser_ID());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Ticket setTicket(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SetPassword(String email, String oldPass, String newPass) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_USERS ERS_Password = ? where USER_EMAIL=? and ERS_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, oldPass);
			ps.setString(2, email);
			ps.setString(3, newPass);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
