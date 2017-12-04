package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;
import com.ers.util.ConnectionFactory;

public class ReimbDAOImp implements ReimbDAO
{

	@Override
	public ArrayList<Reimbursement> getAllReimb(User user)
	{
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbById(User user)
	{
		return null;
	}

	@Override
	public Reimbursement addReimb(User user, Reimbursement reimb)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "REIMB_ID";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setDouble(1, reimb.getReimbAmount());
			ps.setString(2, reimb.getReimbDescription());
			ps.setInt(3, user.getUserId());
			ps.setInt(4, reimb.getReimbStatusId());
			ps.setInt(5, reimb.getReimbTypeId());

			ps.executeUpdate();

			/*
			 * int rows = ps.executeUpdate();
			 * 
			 * if (rows != 0) { ResultSet rs = ps.getGeneratedKeys(); while (rs.next()) {
			 * reimb.setReimbId(rs.getInt(1)); reimb.setReimbAmount(rs.getInt(2));
			 * reimb.setReimbSubmitted(rs.getString(3));
			 * reimb.setReimbResolved(rs.getString(4));
			 * reimb.setReimbDescription(rs.getString(5));
			 * reimb.setReimbReceipt(rs.getString(6)); reimb.setReimbAuthor(rs.getInt(7));
			 * reimb.setReimbResolver(rs.getInt(8)); reimb.setReimbStatusId(rs.getInt(9));
			 * reimb.setReimbTypeId(rs.getInt(10)); }
			 * 
			 * conn.commit(); }
			 */

		} catch (SQLException e)
		{
			// e.printStackTrace();
		}

		if (reimb.getReimbId() != 0)

			return reimb;
		else
			return null;
	}

	@Override
	public Reimbursement getReimb(int remb_id)
	{
		return null;
	}

	@Override
	public void updateReimb(Reimbursement reimb)
	{

	}

	@Override
	public void deleteReimb(int reimb_id)
	{

	}

}
