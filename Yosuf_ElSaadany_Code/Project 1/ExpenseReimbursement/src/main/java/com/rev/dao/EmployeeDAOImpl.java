package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	public User Login(User u) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				user.setUsername(info.getString("USERNAME"));
				if(user.getUsername().equals(u.getUsername())) {
					user.setPassword(info.getString("PASSWORD"));
					if(user.getPassword().equals(u.getPassword())) {
						return user;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement>  viewPastTickets(User u) {
		ReimbursementStatus rs = new ReimbursementStatus();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			// Get user_id from the user table in order to get the reimbursements using that user_id
			String sql1 = "select user_id from users where username = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, u.getUsername());
			ResultSet info1 = ps1.executeQuery();
			while(info1.next()) {
				u.setUser_id(info1.getInt("USER_ID"));
			}
			
			//String sql = "select * from reimbursement where author = ?";
			String sql = "select * from reimbursement re inner join reimbursement_status res "
						+ "on re.STATUS_ID = res.STATUS_ID where author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, u.getUser_id());
			ResultSet info = ps.executeQuery();
			ArrayList<Reimbursement> pastTickets = new ArrayList<Reimbursement>();
			while(info.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimb_id(info.getInt("REIMB_ID"));
				r.setAmount(info.getInt("AMOUNT"));
				r.setSubmitted(info.getTimestamp("SUBMITTED"));
				r.setResolved(info.getTimestamp("RESOLVED"));
				r.setDescription(info.getString("DESCRIPTION"));
				r.setAuthor(info.getInt("AUTHOR"));
				r.setResolver(info.getInt("RESOLVER"));
				r.setStatus(info.getInt("STATUS_ID"));
				r.setType(info.getInt("TYPE_ID"));
				rs.setStatus_id(info.getInt(10));
				rs.setStatus(info.getString(11));
				pastTickets.add(r);
			}
			return pastTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement AddReimbursement(Reimbursement r, User u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			// Get User ID
			String sql3 = "select user_ID from users where username = ?";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setString(1, u.getUsername());
			ResultSet rs0 = ps3.executeQuery();
			if(rs0.next()) {
				System.out.println("Here");
				r.setAuthor(rs0.getInt(1));
			}
			// The following query gets the next value of the Reimb_ID from the sequence defined in Oracle
			int Reimb_ID = 0;
			String sqlIdentifier1 = "select REIMBURSEMENT_SEQ.NEXTVAL from dual";
			PreparedStatement pst1 = conn.prepareStatement(sqlIdentifier1);
			synchronized( this ) {
			   ResultSet rs1 = pst1.executeQuery();
			   if(rs1.next())
				   Reimb_ID = rs1.getInt(1);
			   	   r.setReimb_id(Reimb_ID);
			}
			
			// Inserting data into reimbursement table
			String sql2 = "insert into REIMBURSEMENT (Reimb_ID, Amount, Submitted, Description, Author, Type_ID) "
										+ "values (?,?,?,?,?,?)";
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, r.getReimb_id());
			ps2.setDouble(2, r.getAmount());
			ps2.setTimestamp(3, Timestamp.from(java.time.Instant.now()));
			ps2.setString(4, r.getDescription());
			ps2.setInt(5, r.getAuthor());
			ps2.setInt(6, r.getType());
			int rows2 = ps2.executeUpdate();
			if(rows2 == 1) {
				System.out.println("Row Inserted In Reimbursement");
				System.out.println(r.toString());
			}
			
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return null;		
	}
}


