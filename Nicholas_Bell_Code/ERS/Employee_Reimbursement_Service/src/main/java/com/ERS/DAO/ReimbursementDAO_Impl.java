package com.ERS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ERS.pojos.REIMBURSEMENT_STATUS;
import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;
import com.ERS.util.ConnectionFactory;

public class ReimbursementDAO_Impl implements ReimbursementDAO {



	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		
		return null;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement ri, User u) {
		Reimbursement r = new Reimbursement(ri);
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			//Reimbursement has amount, type of reimbursement
			//adds date, status, R_ID, 
			String sql = " insert into ers_reimbursement(REIMB_AMOUNT,REIMB_SUBMITTED,reimb_author,reimb_type_id) values (?, sysdate, ?, ?)";
			String[] key = new String[2];
			key[0] = "REIMB_ID";
			//key[1] = "REIMB_STATUS_ID";
			//will be 0 on creation; maybe turn this into a DTO?
			
			key[1] = "REIMB_SUBMITTED";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, r.getAmount());
			ps.setInt(2, u.getUser_id());
			ps.setInt(3, r.getType().ordinal());
			int rows = ps.executeUpdate();
			
			if (rows!=0) {
				ResultSet rs = ps.getGeneratedKeys();
				r.setReimbursment_id(rs.getInt(1));
				r.setSubmitted(rs.getDate(2));
				r.setStatus(REIMBURSEMENT_STATUS.PENDING);
				
				
			}
			conn.commit();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}
