package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;
import com.ers.util.ConnectionFactory;

public class ReimbDAOImp implements ReimbDAO
{

	@Override
	public ArrayList<Reimbursement> getAllReimb()
	{
		ArrayList<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_RESOLVED IS NULL";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
			{
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getString(3));
				temp.setReimbResolved(rs.getString(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbReceipt(rs.getBlob(6));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		for (int i = 0; i < reimbs.size(); i++)
		{
			System.out.println(reimbs.get(i).toString());
		}

		if (reimbs.size() > 0)
			return reimbs;
		else
			return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbByUser(User user)
	{
		ArrayList<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql;
			if (user.getRoleId() == 1)
			{
				sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			} else if (user.getRoleId() == 2)
			{
				sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_RESOLVED IS NULL OR REIMB_RESOLVER = ?";
			} else { return null; } 
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getString(3));
				temp.setReimbResolved(rs.getString(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbReceipt(rs.getBlob(6));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbs.add(temp);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		if (reimbs.size() > 0)
			return reimbs;
		else
			return null;
	}

	@Override
	public Reimbursement addReimb(User user, Reimbursement reimb)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_TYPE_ID) VALUES (?,?,?,?)";
			String[] key = new String[1];
			key[0] = "REIMB_ID";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setDouble(1, reimb.getReimbAmount());
			ps.setString(2, reimb.getReimbDescription());
			ps.setInt(3, user.getUserId());
			ps.setInt(4, reimb.getReimbTypeId());

			int rows = ps.executeUpdate();

			if (rows != 0)
			{
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next())
				{
					reimb.setReimbId(rs.getInt(1));
					reimb.setReimbAmount(rs.getDouble(2));
					reimb.setReimbSubmitted(rs.getString(3));
					reimb.setReimbResolved(rs.getString(4));
					reimb.setReimbDescription(rs.getString(5));
					reimb.setReimbReceipt(rs.getBlob(6));
					reimb.setReimbAuthor(rs.getInt(7));
					reimb.setReimbResolver(rs.getInt(8));
					reimb.setReimbStatusId(rs.getInt(9));
					reimb.setReimbTypeId(rs.getInt(10));
				}

				conn.commit();
			}

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
	public Reimbursement getReimb(int reimbId)
	{

		Reimbursement temp = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getString(3));
				temp.setReimbResolved(rs.getString(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbReceipt(rs.getBlob(6));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
			}
		} catch (SQLException e)
		{
			// e.printStackTrace();
		}
		
		if (temp.getReimbId() != 0)

			return temp;
		else
			return null;
	}

	@Override
	public void updateReimb(Reimbursement reimb)
	{

	}

	@Override
	public void updateReimbByManager(User user, int statusId, int reimbId)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVER = ?, REIMB_STATUS_ID = ?, REIMB_RESOLVED = CURRENT_TIMESTAMP WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, statusId);
			ps.setInt(3, reimbId);
			ps.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReimb(int reimb_id)
	{

	}

}
