package com.ERS.DAO;

import java.lang.System;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ERS.pojos.REIMBURSEMENT_STATUS;
import com.ERS.pojos.ReimbRow;
import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;
import com.ERS.util.ConnectionFactory;

public class ReimbursementDAO_Impl implements ReimbursementDAO {

	private static java.sql.Timestamp getCurTime(){
		java.util.Date date = new java.util.Date();
		return new java.sql.Timestamp(date.getTime());
	}

	@Override
	public ArrayList<ReimbRow> getAllReimbursements() {
		ArrayList<ReimbRow> tickets = new ArrayList<>();
		String sql = "select r.REIMB_ID as ID, concat(concat(u.user_first_name, ' '), u.user_last_name) as AuthorName, r.reimb_amount as amount, t.reimb_type as type, r.REIMB_DESCRIPTION as Disc," + 
				"r.reimb_submitted as Submit_Date, s.reimb_status as Status, concat(concat(m.user_first_name, ' '), m.user_last_name) as ResolverName, r.REIMB_RESOLVED as resolve_date " + 
				"from ERS_REIMBURSEMENT r " + 
				"inner join ERS_USERS u " + 
				"on r.reimb_author = u.ERS_USERS_ID " + 
				"left join ERS_USERS m " + 
				"on r.reimb_resolver = m.ERS_USERS_ID " + 
				"inner join ers_reimbursement_type t " + 
				"on r.REIMB_TYPE_ID = t.REIMB_TYPE_ID " + 
				"inner join ers_reimbursement_status s " + 
				"on s.reimb_status_id = r.reimb_status_id";
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
				if(!rs.isBeforeFirst()) {
					tickets = null;
				}
				else {

				while (rs.next()) {
					ReimbRow re = new ReimbRow ();
					re.setReimb_id(rs.getInt("ID"));
					re.setSub_name(rs.getString("AUTHORNAME"));
					re.setAmount(rs.getDouble("AMOUNT"));
					re.setSubmittedD(rs.getString("SUBMIT_DATE"));
					re.setResolvedD(rs.getString("RESOLVE_DATE"));
					re.setDescription(rs.getString("DISC"));
					re.setResolver(rs.getString("RESOLVERNAME"));
					re.setStatus(rs.getString("STATUS"));
					re.setType(rs.getString("TYPE"));
					tickets.add(re);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
		
	
	
	

	@Override
	public Reimbursement addReimbursement(Reimbursement ri, User u) {
		Reimbursement r = new Reimbursement(ri);
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			//Reimbursement has amount, type of reimbursement
			//adds date, status, R_ID, 
			String sql = " insert into ers_reimbursement(REIMB_AMOUNT,REIMB_SUBMITTED,reimb_author,reimb_type_id,reimb_description) values (?, ?, ?, ?, ?)";
			//String[] key = new String[2];
			//key[0] = "REIMB_ID";
			//key[1] = "REIMB_STATUS_ID";
			//will be 0 on creation; maybe turn this into a DTO?
			
			//key[1] = "REIMB_SUBMITTED";
			
			
			PreparedStatement ps = conn.prepareStatement(sql, 
					new String[]{"REIMB_ID","REIMB_SUBMITTED",
							"REIMB_STATUS_ID","REIMB_TYPE_ID"});
			
			conn.setAutoCommit(false);
			ps.setDouble(1, r.getAmount());
			
			
			ps.setTimestamp(2, getCurTime());
			ps.setInt(3, u.getUser_id());
			ps.setInt(4, r.getType());
			ps.setString(5, ri.getDescription());
			System.out.println("before exe");
			int rows = ps.executeUpdate();
			System.out.println("after exe");
			if (rows!=0) {
				System.out.println("before gen keys");
				ResultSet rs = ps.getGeneratedKeys();
				System.out.println("after gen keys");
				rs.next();
				r.setReimbursment_id(rs.getInt(1));
				r.setSubmitted((rs.getTimestamp(2)).toString());
				r.setStatus(rs.getInt(3));
				r.setType(rs.getInt(4));
				
			}
			conn.commit();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<ReimbRow> getUserReimbursements(User u) {
		ArrayList<ReimbRow> tickets = new ArrayList<>();
		String sql = "select r.REIMB_ID as ID, concat(concat(u.user_first_name, ' '), u.user_last_name) as AuthorName, r.reimb_amount as amount, t.reimb_type as type, r.REIMB_DESCRIPTION as Disc," + 
				"r.reimb_submitted as Submit_Date, s.reimb_status as Status, concat(concat(m.user_first_name, ' '), m.user_last_name) as ResolverName, r.REIMB_RESOLVED as resolve_date " + 
				"from ERS_REIMBURSEMENT r " + 
				"inner join ERS_USERS u " + 
				"on r.reimb_author = u.ERS_USERS_ID " + 
				"left join ERS_USERS m " + 
				"on r.reimb_resolver = m.ERS_USERS_ID " + 
				"inner join ers_reimbursement_type t " + 
				"on r.REIMB_TYPE_ID = t.REIMB_TYPE_ID " + 
				"inner join ers_reimbursement_status s " + 
				"on s.reimb_status_id = r.reimb_status_id " +
				"where u.ers_users_id = ?";
		int author = u.getUser_id();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, u.getUser_id());
			ResultSet rs = ps.executeQuery();
				if(!rs.isBeforeFirst()) {
					tickets = null;
				}
				else {

				while (rs.next()) {
					ReimbRow re = new ReimbRow ();
					re.setReimb_id(rs.getInt("ID"));
					re.setSub_name(rs.getString("AUTHORNAME"));
					re.setAmount(rs.getDouble("AMOUNT"));
					re.setSubmittedD(rs.getString("SUBMIT_DATE"));
					re.setResolvedD(rs.getString("RESOLVE_DATE"));
					re.setDescription(rs.getString("DISC"));
					re.setResolver(rs.getString("RESOLVERNAME"));
					re.setStatus(rs.getString("STATUS"));
					re.setType(rs.getString("TYPE"));
					tickets.add(re);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public void resolve(int id, int status, User u) {
		//Reimbursement r = new Reimbursement(id);
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			//Reimbursement has amount, type of reimbursement
			//adds date, status, R_ID, 
			String sql = "update ERS_REIMBURSEMENT set REIMB_RESOLVED = ?, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? where REIMB_ID = ?";
			//String[] key = new String[2];
			//key[0] = "REIMB_ID";
			//key[1] = "REIMB_STATUS_ID";
			//will be 0 on creation; maybe turn this into a DTO?
			
			//key[1] = "REIMB_SUBMITTED";
			
			
			PreparedStatement ps = conn.prepareStatement(sql, 
					new String[]{"REIMB_ID","REIMB_SUBMITTED",
							"REIMB_STATUS_ID","REIMB_TYPE_ID"});
			

			conn.setAutoCommit(false);
			
			ps.setTimestamp(1, getCurTime());
			ps.setInt(2, u.getUser_id());
			ps.setInt(3, status);
			ps.setInt(4, id);
			System.out.println("before exe");
			int rows = ps.executeUpdate();
			System.out.println("after exe");
			
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	
}
