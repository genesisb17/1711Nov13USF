package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.ers.pojos.Reimbursement;
import com.revature.ers.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public Reimbursement addReimbursement(Reimbursement newReimbursement) {
		
		Reimbursement reimbursement = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
		
			String sql = "INSERT INTO ers_reimbursements (reimb_amount, reimb_resolved, reimb_description, reimb_receipt, "
					+ "reimb_author, reimb_resolver, reimb_statusId, reimb_typeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			String[] key = new String[9];
			key[0] = "reimb_id";
			key[1] = "reimb_amount";
			key[2] = "reimb_resolved";
			key[3] = "reimb_description";
			key[4] = "reimb_receipt";
			key[5] = "reimb_author";
			key[6] = "reimb_resolver";
			key[7] = "reimb_statusId";
			key[8] = "reimb_typeId";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setDouble(1, newReimbursement.getAmount());
			pstmt.setTimestamp(2, newReimbursement.getTimeResolved());
			pstmt.setString(3, newReimbursement.getDescription());
			pstmt.setBytes(4, newReimbursement.getReceipt());
			pstmt.setInt(5, newReimbursement.getAuthorId());
			pstmt.setInt(6, newReimbursement.getResolverId());
			pstmt.setInt(7, newReimbursement.getStatusId());
			pstmt.setInt(8, newReimbursement.getTypeId());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					reimbursement.setReimbursementId(rs.getInt(1));
				}
				
				reimbursement.setAmount(newReimbursement.getAmount());
				reimbursement.setTimeResolved(newReimbursement.getTimeResolved());
				reimbursement.setDescription(newReimbursement.getDescription());
				reimbursement.setReceipt(newReimbursement.getReceipt());
				reimbursement.setAuthorId(newReimbursement.getAuthorId());
				reimbursement.setResolverId(newReimbursement.getResolverId());
				reimbursement.setStatusId(newReimbursement.getStatusId());
				reimbursement.setTypeId(newReimbursement.getTypeId());
				
				conn.commit();
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public Reimbursement getReimbursementById(int reimbursementId) {
		
		Reimbursement reimbursement = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursements WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursementId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reimbursement.setReimbursementId(rs.getInt(1));
				reimbursement.setAmount(rs.getDouble(2));
				reimbursement.setTimeResolved(rs.getTimestamp(3));
				reimbursement.setDescription(rs.getString(4));
				reimbursement.setReceipt(rs.getBytes(5));
				reimbursement.setAuthorId(rs.getInt(6));
				reimbursement.setResolverId(rs.getInt(7));
				reimbursement.setStatusId(rs.getInt(8));
				reimbursement.setTypeId(rs.getInt(9));
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursements";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setTimeResolved(rs.getTimestamp(3));
				temp.setDescription(rs.getString(4));
				temp.setReceipt(rs.getBytes(5));
				temp.setAuthorId(rs.getInt(6));
				temp.setResolverId(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
				reimbursements.add(temp);
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByAuthor(int authorId) {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursements WHERE reimb_author = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, authorId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setTimeResolved(rs.getTimestamp(3));
				temp.setDescription(rs.getString(4));
				temp.setReceipt(rs.getBytes(5));
				temp.setAuthorId(rs.getInt(6));
				temp.setResolverId(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
				reimbursements.add(temp);
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursements;
		
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByResolver(int resolverId) {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursements WHERE reimb_resolver = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resolverId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setTimeResolved(rs.getTimestamp(3));
				temp.setDescription(rs.getString(4));
				temp.setReceipt(rs.getBytes(5));
				temp.setAuthorId(rs.getInt(6));
				temp.setResolverId(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
				reimbursements.add(temp);
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByType(int typeId) {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursements WHERE reimb_typeId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setTimeResolved(rs.getTimestamp(3));
				temp.setDescription(rs.getString(4));
				temp.setReceipt(rs.getBytes(5));
				temp.setAuthorId(rs.getInt(6));
				temp.setResolverId(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
				reimbursements.add(temp);
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByStatus(int statusId) {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursements WHERE reimb_statusId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, statusId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setTimeResolved(rs.getTimestamp(3));
				temp.setDescription(rs.getString(4));
				temp.setReceipt(rs.getBytes(5));
				temp.setAuthorId(rs.getInt(6));
				temp.setResolverId(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
				reimbursements.add(temp);
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public Reimbursement updateReimbursement(int reimbursementId, Reimbursement reimbursement) {
		
		Reimbursement updatedReimbursement = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ers_reimbursements SET reimb_amount = ?, reimb_resolved = ?, reimb_description = ?, reimb_receipt = ?, "
					+ "reimb_author = ?, reimb_resolver = ?, reimb_statusId = ?, reimb_typeId = ? WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, reimbursement.getAmount());
			pstmt.setTimestamp(2, reimbursement.getTimeResolved());
			pstmt.setString(3, reimbursement.getDescription());
			pstmt.setBytes(4, reimbursement.getReceipt());
			pstmt.setInt(5, reimbursement.getAuthorId());
			pstmt.setInt(6, reimbursement.getResolverId());
			pstmt.setInt(7, reimbursement.getStatusId());
			pstmt.setInt(8, reimbursement.getTypeId());
			pstmt.setInt(9, reimbursementId);
			
			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				updatedReimbursement = getReimbursementById(reimbursementId);
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedReimbursement;
		
	}

	@Override
	public void removeReimbursement(int reimbursementId) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursementId);
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
