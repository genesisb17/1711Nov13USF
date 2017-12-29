package com.real.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.real.pojos.TableRow;
import com.real.pojos.User;
import com.real.util.ConnectionFactory;

public class FileDAO implements DAO{
	
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ROLE_ID) VALUES(?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getuName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getfName());
			ps.setString(4, u.getlName());
			ps.setInt(5, u.getRole());
			ps.executeUpdate();
			
			ResultSet pk = ps.getGeneratedKeys(); // only retrieve auto-generated keys
			pk.next();
			int id = pk.getInt(1);
			

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public User getUser(String username) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // Goes by order of question marks
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u.setId(info.getInt(1));
				u.setuName(info.getString(2));
				u.setPassword(info.getString(3));
				u.setfName(info.getString(4));
				u.setlName(info.getString(5));
				u.setRole(info.getInt(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void addReimbursement(User u, String[] rb) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES(?, CURRENT_TIMESTAMP(0), NULL, ?, ?, '', 1, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, Double.parseDouble(rb[0]));
			ps.setString(2, rb[2]);
			ps.setInt(3, u.getId());
			ps.setInt(4, Integer.parseInt(rb[1]));
			ps.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<TableRow> getReimbursements(User user) {
		ArrayList<TableRow> rows = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			if(user.getRole() == 2) {
				System.out.println("Manager table");
				String sql = "select reimb_id, reimb_status, reimb_amount, reimb_type, trunc(reimb_submitted, 'MI'), "
						+ "reimb_description, first_name, last_name, trunc(reimb_resolved, 'MI') from reimbursement inner join reimbursement_status "
						+ "on reimbursement.reimb_status_id = reimbursement_status.reimb_status_id inner join "
						+ "reimbursement_type on reimbursement.reimb_type_id = reimbursement_type.reimb_type_id "
						+ "inner join users on user_id = reimb_author";
				Statement s = conn.createStatement();
				ResultSet info = s.executeQuery(sql);
				while(info.next()) {
					TableRow row = new TableRow(info.getInt(1), info.getString(2), info.getDouble(3), 
							info.getString(4), info.getString(5), info.getString(6), info.getString(7),
							info.getString(8), info.getString(9));
					rows.add(row);
				}
			}
			else{
				System.out.println("User table");
				String sql = "select reimb_id, reimb_status, reimb_amount, reimb_type, trunc(reimb_submitted, 'MI'), "
						+ "reimb_description, first_name, last_name, trunc(reimb_resolved, 'MI') from reimbursement inner join reimbursement_status "
						+ "on reimbursement.reimb_status_id = reimbursement_status.reimb_status_id inner join "
						+ "reimbursement_type on reimbursement.reimb_type_id = reimbursement_type.reimb_type_id "
						+ "inner join users on user_id = reimb_author where reimb_author = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, user.getId());
				ResultSet info = ps.executeQuery();
				while(info.next()) {
					TableRow row = new TableRow(info.getInt(1), info.getString(2), info.getDouble(3), 
							info.getString(4), info.getString(5), info.getString(6), info.getString(7),
							info.getString(8), info.getString(9));
					rows.add(row);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public void updateReimbursement(String[] vals) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			int status = 1;			
			if(vals[1].equals("Approved")) {
				status = 2;
			}
			else if(vals[1].equals("Denied")) {
				status = 3;
			}
			conn.setAutoCommit(false);
			String sql;
			if(status == 1) {
				sql = "UPDATE REIMBURSEMENT SET REIMB_STATUS_ID = ?, REIMB_RESOLVER = NULL, REIMB_RESOLVED = NULL WHERE REIMB_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, status);
				ps.setInt(2, Integer.parseInt(vals[0]));
				ps.executeUpdate();
				
				conn.commit();
			}
			else {
				sql = "UPDATE REIMBURSEMENT SET REIMB_STATUS_ID = ?, REIMB_RESOLVER = ?, REIMB_RESOLVED = CURRENT_TIMESTAMP(0) WHERE REIMB_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, status);
				ps.setInt(2, Integer.parseInt(vals[2]));
				ps.setInt(3, Integer.parseInt(vals[0]));
				ps.executeUpdate();
				
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}