package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static final int STATUS_PENDING = 101;

	private static final int MANAGER_ROLE_ID = 100;
	private static final int EMPLOYEE_ROLE_ID = 200;

	@Override
	public Reimbursement addReimbursement(User u, double amount, String description, int typeId) {
		
		Reimbursement r = new Reimbursement();
		r.setAmount(amount);
		r.setSubmitted(new Timestamp(System.currentTimeMillis()));
		r.setDescription(description);
		r.setAuthorId(u.getUserId());
		r.setStatusId(STATUS_PENDING);
		r.setTypeId(typeId);
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql =  "INSERT INTO ERS_Reimbursements (Reimb_Amount, Reimb_Submitted, Reimb_Description"
					+ ", Reimb_Author, Reimb_Status_Id, Reimb_Type_Id)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "Reimb_Id";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmitted());
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getAuthorId());
			ps.setInt(5, r.getStatusId());
			ps.setInt(6, r.getTypeId());

			int rows = ps.executeUpdate();

			if (rows != 0) {
				System.out.println("insertion worked rows != 0");
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					r.setReimbursementId(rs.getInt(1));
				}

				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (r.getReimbursementId() == 0) ? null : r;
	}

	@Override
	public List<Reimbursement> getUserReimbursements(User u) {
		List<Reimbursement> reimbursementsList = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql;

			if (u.getRoleId() == MANAGER_ROLE_ID)
				sql = "SELECT * FROM ERS_Reimbursements WHERE Reimb_Resolved IS NULL OR Reimb_Resolver = ?";
			else if (u.getRoleId() == EMPLOYEE_ROLE_ID)
				sql = "SELECT * FROM ERS_Reimbursements WHERE Reimb_Author = ?";
			else
				return reimbursementsList; // just return the empty list if user role id isn't valid

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthorId(rs.getInt(7));
				temp.setResolverId(rs.getInt(8));
				temp.setStatusId(rs.getInt(9));
				temp.setTypeId(rs.getInt(10));
				reimbursementsList.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursementsList;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursementsList = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_Reimbursements WHERE Reimb_Resolved IS NULL";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			reimbursementsList = new ArrayList<Reimbursement>();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursementId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthorId(rs.getInt(7));
				temp.setResolverId(rs.getInt(8));
				temp.setStatusId(rs.getInt(9));
				temp.setTypeId(rs.getInt(10));
				reimbursementsList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursementsList;
	}

	@Override
	public Reimbursement getReimbursement(int id) {
		return null;
	}

	@Override
	public void updateReimbursement(User manager, int reimbId, int statusId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE ERS_Reimbursements SET Reimb_Resolver = ?, Reimb_Status_Id = ?, Reimb_Resolved = CURRENT_TIMESTAMP WHERE Reimb_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, manager.getUserId());
			ps.setInt(2, statusId);
			ps.setInt(3, reimbId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReimbursement(int reimbId) {
	}

}
