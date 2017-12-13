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
						user.setFirstname(info.getString("FIRST_NAME"));
						user.setLastname(info.getString("LAST_NAME"));
						user.setEmail(info.getString("EMAIL"));
						user.setUserRole(info.getInt("USER_ROLE_ID"));
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
	public int Register(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			// Get User ID
			User user = new User();
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setUsername(rs.getString("USERNAME"));
				user.setEmail(rs.getString("EMAIL"));
			}
			
			if(user.getUsername().equals(u.getUsername()) || user.getEmail().equals(u.getEmail()))
				return 0;
			
			String sql3 = "select USER_SEQ.NEXTVAL from dual";
			PreparedStatement pst1 = conn.prepareStatement(sql3);
			synchronized( this ) {
			   ResultSet rs1 = pst1.executeQuery();
			   if(rs1.next())
				   u.setUser_id(rs1.getInt(1));
			}
						
			String sql1 = "insert into users (user_id, username, password, first_name, last_name, email, user_role_id) "
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, u.getUser_id());
			ps1.setString(2, u.getUsername());
			ps1.setString(3, u.getPassword());
			ps1.setString(4, u.getFirstname());
			ps1.setString(5, u.getLastname());
			ps1.setString(6, u.getEmail());
			ps1.setInt(7, u.getUserRole());
			ps1.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public User UpdateInfo(User newuser, User olduser) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			System.out.println("THE OLD USER IS: " + olduser.toString());
			System.out.println("THE NEW USER IS: " + newuser.toString());
			
			if(newuser.getUsername() == "")
				newuser.setUsername(olduser.getUsername());
			if(newuser.getPassword() == "")
				newuser.setPassword(olduser.getPassword());
			if(newuser.getFirstname() == "")
				newuser.setFirstname(olduser.getFirstname());
			if(newuser.getLastname() == "")
				newuser.setLastname(olduser.getLastname());
			if(newuser.getEmail() == "")
				newuser.setEmail(olduser.getEmail());
			
			newuser.setUserRole(olduser.getUserRole());
			
			String sql = "update users set username = ?, password = ?, first_name = ?,"
					+ " last_name = ?, email = ? where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newuser.getUsername());
			ps.setString(2, newuser.getPassword());
			ps.setString(3, newuser.getFirstname());
			ps.setString(4, newuser.getLastname());
			ps.setString(5, newuser.getEmail());
			ps.setString(6, olduser.getUsername());
			int rows = ps.executeUpdate();
			while(rows == 1) {
				System.out.println("NEW USER: " + newuser.toString());
				return newuser;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Reimbursement> viewPastTickets(User u) {
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
			
			String sql = "select * from reimbursement where author = ?";
			/*String sql = "select * from reimbursement re inner join reimbursement_status res "
						+ "on re.STATUS_ID = res.STATUS_ID where author = ?";*/
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, u.getUser_id());
			ResultSet info = ps.executeQuery();
			ArrayList<Reimbursement> pastTickets = new ArrayList<Reimbursement>();
			while(info.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimb_id(info.getInt("REIMB_ID"));
				r.setAmount(info.getDouble("AMOUNT"));
				r.setSubmitted(info.getTimestamp("SUBMITTED").toString());

				if(info.getTimestamp("RESOLVED") == null)
					r.setResolved(null);
				else
					r.setResolved(info.getTimestamp("RESOLVED").toString());
				
				r.setDescription(info.getString("DESCRIPTION"));
				r.setAuthor(info.getInt("AUTHOR"));
				r.setResolver(info.getInt("RESOLVER"));
				r.setStatus(info.getInt("STATUS_ID"));
				r.setType(info.getInt("TYPE_ID"));
				
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
			   	   System.out.println("2) Reimb_ID: " + rs0.getInt(1));
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


