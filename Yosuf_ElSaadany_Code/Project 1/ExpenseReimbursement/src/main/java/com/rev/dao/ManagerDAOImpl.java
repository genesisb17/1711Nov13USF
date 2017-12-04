package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public ArrayList<Reimbursement> viewAllTickets() {
		ArrayList<Reimbursement> allTickets = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from reimbursement";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimb_id(rs.getInt("REIMB_ID"));
				r.setAmount(rs.getInt("AMOUNT"));
				r.setSubmitted(rs.getTimestamp("SUBMITTED"));
				r.setResolved(rs.getTimestamp("RESOLVED"));
				r.setDescription(rs.getString("DESCRIPTION"));
				r.setAuthor(rs.getInt("AUTHOR"));
				r.setResolver(rs.getInt("RESOLVER"));
				r.setStatus(rs.getInt("STATUS_ID"));
				r.setType(rs.getInt("TYPE_ID"));
				allTickets.add(r);
			}
			return allTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	public ArrayList<Reimbursement> filterByStatus(ReimbursementStatus rs) {
		ArrayList<Reimbursement> allTickets = new ArrayList<>();
		Reimbursement r = new Reimbursement();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "{call filter_by_status(?,?)}";
			CallableStatement cs = connect.prepareCall(sql);
			cs.setInt(1, rs.getStatus_id());
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			System.out.println("HERE");
			ResultSet RS = (ResultSet) cs.getObject(2);
			
			while(RS.next()){
				allTickets.add(new Reimbursement(RS.getInt(1),RS.getInt(2),RS.getTimestamp(3), RS.getTimestamp(4),
								RS.getString(5), RS.getInt(6), RS.getInt(7), RS.getInt(8), RS.getInt(9)));
				
			}
			return allTickets;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int processRequest(int Status_ID, int Reimb_ID) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "update reimbursement set status_ID = ? where reimb_ID = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setInt(1, Status_ID);
			ps1.setInt(2, Reimb_ID);
			int rows = ps1.executeUpdate();
			if(rows == 1)
				return 1;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
