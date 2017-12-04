package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.ers.pojos.ReimbursementType;
import com.revature.ers.pojos.Type;
import com.revature.ers.util.ConnectionFactory;

public class ReimbursementTypeDAOImpl implements ReimbursementTypeDAO {

	@Override
	public ReimbursementType addReimbursementType(ReimbursementType newReimbursementType) {
		
		ReimbursementType reimbursementType = new ReimbursementType();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ers_reimbursement_type (reimb_type) VALUES (?)";
			
			String[] key = new String[2];
			key[0] = "reimb_typeId";
			key[1] = "reimb_type";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, newReimbursementType.getType().toString());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rowsUpdated != 0) {
				
				while (rs.next()) {
					reimbursementType.setTypeId(rs.getInt(1));
				}
				
				reimbursementType.setType(newReimbursementType.getType());
				
				conn.commit();
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursementType;
	}

	@Override
	public ReimbursementType getReimbursementTypeById(int typeId) {
		
		ReimbursementType reimbursementType = new ReimbursementType();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_typeId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reimbursementType.setTypeId(rs.getInt(1));
				reimbursementType.setType(Type.valueOf(rs.getString(2)));
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursementType;
	}

	@Override
	public ArrayList<ReimbursementType> getAllReimbursementTypes() {
		
		ArrayList<ReimbursementType> reimbursementTypes = new ArrayList<ReimbursementType>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_reimbursement_type";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ReimbursementType temp = new ReimbursementType();
				temp.setTypeId(rs.getInt(1));
				temp.setType(Type.valueOf(rs.getString(2)));
				reimbursementTypes.add(temp);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return reimbursementTypes;
	}

	@Override
	public ReimbursementType updateReimbursementType(int typeId, ReimbursementType reimbursementType) {
		
		ReimbursementType updatedReimbursementType = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "UPDATE ers_reimbursement_type SET reimb_type = ? WHERE reimb_typeId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reimbursementType.getType().toString());
			pstmt.setInt(2, typeId);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				updatedReimbursementType = getReimbursementTypeById(typeId);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedReimbursementType;
	}

	@Override
	public void removeReimbursementType(int typeId) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM ers_reimbursement_type WHERE reimb_typeId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
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
