package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.DTOs.ManagerTicketInfo;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ManagerDAOImpl implements ManagerDAO {

	public ArrayList<ManagerTicketInfo> filterByStatus(ReimbursementStatus rs) {
		ArrayList<ManagerTicketInfo> allTickets = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			// CALLABLE STATEMENT TO RETRIEVE ALL REIMBURSEMENTS WITH SPECIFIED STATUS_ID
			String sql = "{call filter_by_status(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, rs.getStatus_id());
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs1 = (ResultSet) cs.getObject(2);
			
			// SELECTING RESOLVER'S FIRST AND LAST NAMES
			String sql2 = "select u.first_name, u.last_name from users u right join reimbursement rb on rb.resolver = u.user_id where status_id = ? order by reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setInt(1, rs.getStatus_id());
			ResultSet rs2 = ps.executeQuery();
			
			while(rs1.next()){
				ManagerTicketInfo m = new ManagerTicketInfo();
				m.setReimb_id(rs1.getInt("REIMB_ID"));
				m.setFirstname(rs1.getString("FIRST_NAME"));
				m.setLastname(rs1.getString("LAST_NAME"));
				m.setEmail(rs1.getString("EMAIL"));
				m.setAmount(rs1.getDouble("AMOUNT"));
				m.setStatus(rs1.getInt("STATUS_ID"));
				m.setType(rs1.getInt("TYPE_ID"));
				m.setDescription(rs1.getString("DESCRIPTION"));
				m.setSubmitted(rs1.getString("SUBMITTED"));
				
				if(rs1.getTimestamp("RESOLVED") == null)
					m.setResolved(null);
				else
					m.setResolved(rs1.getTimestamp("RESOLVED").toString());
			
				if(rs2.next()) {
					m.setResolverfn(rs2.getString("FIRST_NAME"));
					m.setResolverln(rs2.getString("LAST_NAME"));
				}	
				allTickets.add(m);
			}
			return allTickets;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int processRequest(int Status_ID, int Reimb_ID, int Resolver_ID) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "update reimbursement set resolver = ?, status_ID = ? where reimb_ID = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setInt(1, Resolver_ID);
			ps1.setInt(2, Status_ID);
			ps1.setInt(3, Reimb_ID);
			int rows = ps1.executeUpdate();
			if(rows == 1)
				return 1;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<ManagerTicketInfo> managerTicketInfo() {
		ArrayList<ManagerTicketInfo> allTickets = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select rb.Reimb_ID, u.first_name, u.last_name, u.email, rb.Amount, rb.Status_ID,  rb.Type_ID, rb.Description, rb.Submitted, rb.Resolved from users u inner join reimbursement rb on rb.author = u.user_id order by reimb_id";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			String sql1 = "select u.first_name, u.last_name from users u right join reimbursement rb on rb.resolver = u.user_id order by reimb_id";
			Statement statement1 = conn.createStatement();
			ResultSet rs1 = statement1.executeQuery(sql1);
			
			while(rs.next()) {
				ManagerTicketInfo m = new ManagerTicketInfo();
				m.setReimb_id(rs.getInt("REIMB_ID"));
				m.setFirstname(rs.getString("FIRST_NAME"));
				m.setLastname(rs.getString("LAST_NAME"));
				m.setEmail(rs.getString("EMAIL"));
				m.setAmount(rs.getDouble("AMOUNT"));
				m.setStatus(rs.getInt("STATUS_ID"));
				m.setType(rs.getInt("TYPE_ID"));
				m.setDescription(rs.getString("DESCRIPTION"));
				m.setSubmitted(rs.getString("SUBMITTED"));
				
				if(rs.getTimestamp("RESOLVED") == null)
					m.setResolved(null);
				else
					m.setResolved(rs.getTimestamp("RESOLVED").toString());
			
				if(rs1.next()) {
					m.setResolverfn(rs1.getString("FIRST_NAME"));
					m.setResolverln(rs1.getString("LAST_NAME"));
				}	
				allTickets.add(m);
			}
	
			System.out.println(allTickets.toString());
			return allTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

}
