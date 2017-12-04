package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.ers.pojos.Status;
import com.revature.ers.pojos.ReimbursementStatus;
import com.revature.ers.util.ConnectionFactory;

public class ReimbursementStatusDAOImpl implements ReimbursementStatusDAO {

	@Override
	public ReimbursementStatus addReimbursementStatus(ReimbursementStatus newReimbursementStatus) {
		
		ReimbursementStatus reimbursementStatus = new ReimbursementStatus();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "INSERT INTO ers_reimbursement_status (reimb_statusId) VALUES (?)";
			
			String[] key = new String[2];
			key[0] = "reimb_statusId";
			key[1] = "reimb_status";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, newReimbursementStatus.getStatus().toString());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rowsUpdated != 0) {
				
				while(rs.next()) {
					reimbursementStatus.setStatusId(rs.getInt(1));
				}
				
				reimbursementStatus.setStatus(newReimbursementStatus.getStatus());
				
				conn.commit();
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursementStatus;
	}

	@Override
	public ReimbursementStatus getReimbursementStatusById(int statusId) {
		
		ReimbursementStatus reimbursementStatus = new ReimbursementStatus();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, statusId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reimbursementStatus.setStatusId(rs.getInt(1));
				reimbursementStatus.setStatus(Status.valueOf(rs.getString(2)));
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursementStatus;
	}

	@Override
	public ArrayList<ReimbursementStatus> getAllReimbursementStatuses() {
		
		ArrayList<ReimbursementStatus> reimbursementStatuses = new ArrayList<ReimbursementStatus>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursement_status";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ReimbursementStatus temp = new ReimbursementStatus();
				temp.setStatusId(rs.getInt(1));
				temp.setStatus(Status.valueOf(rs.getString(2)));
				reimbursementStatuses.add(temp);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursementStatuses;
	}

	@Override
	public ReimbursementStatus updateReimbursementStatus(int statusId, ReimbursementStatus reimbursementStatus) {
		
		ReimbursementStatus updatedReimbursementStatus = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ers_reimbursement_status SET reimb_status = ? WHERE reimb_statusId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reimbursementStatus.getStatus().toString());
			pstmt.setInt(2, statusId);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				updatedReimbursementStatus = getReimbursementStatusById(statusId);
			}
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedReimbursementStatus;
	}

	@Override
	public void removeReimbursementStatus(int statusId) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM ers_reimbursement_status WHERE reimb_statusId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, statusId);
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
			}
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
