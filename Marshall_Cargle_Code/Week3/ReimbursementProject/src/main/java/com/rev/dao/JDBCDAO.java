package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
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
			String sql = "insert into ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) \r\n"
					+ "values ((?), (?), (?), (?), (?),(?))";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, t.getAmount());
			ps.setTimestamp(2, t.getSubmitted());
			ps.setString(3, t.getDescription());
			ps.setInt(4, t.getAuthor_ID());
			ps.setInt(5, t.getStatus_ID());
			ps.setInt(6, t.getType_ID());
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
		SpecTicket t=new SpecTicket();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT r.REIMB_ID AS \"Ticket ID\", u.USER_FIRST_NAME AS \"First Name\", u.USER_LAST_NAME AS \"Last Name\", \r\n" + 
					"  u.USER_EMAIL AS \"Email\", r.REIMB_AMOUNT AS \"Amount\", r.REIMB_SUBMITTED AS \"Date Submitted\",\r\n" + 
					"  r.REIMB_RESOLVED AS \"Date Resolved\", r.REIMB_DESCRIPTION AS \"Description\",\r\n" + 
					"  CONCAT(f.USER_FIRST_NAME,CONCAT(', ',f.USER_LAST_NAME)) AS \"Resolver\",\r\n" + 
					"    s.REIMB_STATUS AS \"Status\", t.REIMB_TYPE AS \"Type\"\r\n" + 
					"    FROM ERS_REIMBURSEMENT r \r\n" + 
					"    left Outer JOIN ERS_USERS u ON r.REIMB_AUTHOR=u.ERS_USERS_ID \r\n" + 
					"    left outer JOIN ERS_REIMBURSEMENT_TYPE t ON r.REIMB_TYPE_ID=t.REIMB_TYPE_ID\r\n" + 
					"    left outer JOIN ERS_REIMBURSEMENT_STATUS s ON r.REIMB_STATUS_ID = s.REIMB_STATUS_ID\r\n" + 
					"    left outer JOIN ERS_USERS f ON f.ERS_USERS_ID=r.REIMB_RESOLVER order by s.REIMB_STATUS desc";
			
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				t.setTicket_id(rs.getInt(1));
				t.setFirstName(rs.getString(2));
				t.setLastName(rs.getString(3));
				t.setEmail(rs.getString(4));
				t.setAmount(rs.getDouble(5));
				if(rs.getTimestamp(6)==null)
					t.setSubmitted("Pending");
				else
					t.setSubmitted(rs.getTimestamp(6).toString());
				if(rs.getTimestamp(7)==null)
					t.setResolved("Pending");
				else
					t.setResolved(rs.getTimestamp(7).toString());
				if(rs.getString(8)==null)
					t.setDescription("Pending");
				else
					t.setDescription(rs.getString(8));
				if(rs.getString(9).equals(", "))
					t.setResolver("Pending");
				else
					t.setResolver(rs.getString(9));
				t.setStatus(rs.getString(10));
				t.setType(rs.getString(11));
				tickets.add(t);
				t=new SpecTicket();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public void setTicket(int ticket_id, int resolver_id, Timestamp t, int status) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_REIMBURSEMENT set REIMB_RESOLVER = ?, REIMB_RESOLVED =?, REIMB_STATUS_ID=? where REIMB_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolver_id);
			ps.setTimestamp(2, t);
			ps.setInt(3, status);
			ps.setInt(4, ticket_id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String SetPassword(String email, String oldPass, String newPass) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_USERS set ERS_Password = ? where USER_EMAIL=? and ERS_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setString(2, email);
			ps.setString(3, oldPass);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newPass;
	}

	@Override
	public String setAccount(int id, String email, String firstname, String lastname) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_USERS set USER_EMAIL = ?, USER_FIRST_NAME =?, USER_LAST_NAME=? where ERS_USERS_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setInt(4, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id+"";
	}

	@Override
	public List<SpecTicket> getUserTickets(int id) {
		List<SpecTicket> tickets = new ArrayList<>();
		SpecTicket t=new SpecTicket();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "{call get_all_tickets( "+id+" , ? )}";
			
			CallableStatement cs = connect.prepareCall(sql);
			//cs.setInt(1, id);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				t.setTicket_id(rs.getInt(1));
				t.setFirstName(rs.getString(2));
				t.setLastName(rs.getString(3));
				t.setEmail(rs.getString(4));
				t.setAmount(rs.getDouble(5));
				if(rs.getTimestamp(6)==null)
					t.setSubmitted("Pending");
				else
					t.setSubmitted(rs.getTimestamp(6).toString());
				if(rs.getTimestamp(7)==null)
					t.setResolved("Pending");
				else
					t.setResolved(rs.getTimestamp(7).toString());
				if(rs.getString(8)==null)
					t.setDescription("Pending");
				else
					t.setDescription(rs.getString(8));
				if(rs.getString(9).equals(", "))
					t.setResolver("Pending");
				else
					t.setResolver(rs.getString(9));
				t.setStatus(rs.getString(10));
				t.setType(rs.getString(11));
				tickets.add(t);
				t=new SpecTicket();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	
	
}
