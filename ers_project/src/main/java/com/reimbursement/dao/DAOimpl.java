package com.reimbursement.dao;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.reimbursement.jdbc.ConnectionFactory;
import com.reimbursement.pojos.Employee;
import com.reimbursement.pojos.Reimbursement;

public class DAOimpl implements DAO {

	@Override
	public ArrayList getAllUsers() {
		ArrayList<Employee> e = new ArrayList<>();

		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Employee temp = new Employee();
				temp.setUserId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setUserRoleId(rs.getInt(7));
				e.add(temp);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		ArrayList<Reimbursement> r = new ArrayList<>();
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
		String sql = "SELECT T2.REIMB_ID, T2.REIMB_AMOUNT, T2.REIMB_RESOLVED, T2.REIMB_DESCRIPTION, T2.REIMB_AUTHOR, T2.REIMB_RECEIPT, T2.REIMB_RESOLVER, T2.REIMB_STATUS_ID, T2.REIMB_TYPE_ID,\r\n" + 
				"T2.REIMB_SUBMITTED, T1.USER_FIRST_NAME, T1.USER_LAST_NAME, T4.REIMB_STATUS, T5.REIMB_TYPE, T3.USER_LAST_NAME AS RESOLVER\r\n" + 
				"FROM ERS_USERS T1\r\n" + 
				"INNER JOIN  ERS_REIMBURSEMENT T2\r\n" + 
				"ON T1.ERS_USERS_ID = T2.REIMB_AUTHOR\r\n" + 
				"LEFT JOIN ERS_USERS T3\r\n" + 
				"ON T2.REIMB_RESOLVER = T3.ERS_USERS_ID\r\n" + 
				"LEFT JOIN ERS_REIMBURSEMENT_STATUS T4\r\n" + 
				"ON T2.REIMB_STATUS_ID = T4.REIMB_STATUS_ID\r\n" + 
				"LEFT JOIN ERS_REIMBURSEMENT_TYPE T5\r\n" + 
				"ON T2.REIMB_TYPE_ID = T5.REIMB_TYPE_ID ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Reimbursement temp = new Reimbursement();
			temp.setReimbId(rs.getInt(1));
			temp.setReimbAmount(rs.getInt(2));
			try {
			temp.setReimbResolved(rs.getTimestamp(3).toString());
			}
			catch(NullPointerException e) {
				temp.setReimbResolved("null");
			}
			temp.setReimbDescription(rs.getString(4));
			temp.setReimbAuthor(rs.getInt(5));
			try {
			temp.setReimbReceipt(rs.getBlob(6).toString());
			}
			catch(NullPointerException e) {
				temp.setReimbReceipt("null");
			}
			temp.setReimbResolver(rs.getInt(7));
			temp.setReimbStatId(rs.getInt(8));
			temp.setReimbTypeId(rs.getInt(9));
			temp.setReimbSubmitted(rs.getTimestamp(10).toString());
			temp.setAuthor(rs.getString(11) + " " + rs.getString(12));
			temp.setrStat(rs.getString(13));
			temp.setrType(rs.getString(14));
			temp.setResolver(rs.getString(15));
			r.add(temp);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Employee registerUser(String username, String password, String firstname, String ln, String email, Integer rId) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		try (Connection con = ConnectionFactory.getInstance().getConnection()) {
			con.setAutoCommit(false); // Set to false to make sure it has properly changed
			String sql = "insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values (?, ?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "ERS_USERS_ID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstname);
			ps.setString(4, ln);
			ps.setString(5, email);
			ps.setInt(6, rId);
			
			int row = ps.executeUpdate(); // could set variable to track that the update happened
			if(row != 0) {
				emp = new Employee(username, password, firstname, ln, email, rId);
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
				emp.setUserId(rs.getInt(1));
			}
				System.out.println("Emp: " + emp.toString());
				con.commit();
				System.out.println("Does this Commit?");
				return emp;
			}
//				emp.setFirstName(e.getFirstName());
//				emp.setLastName(e.getLastName());
//				emp.setUserName(e.getUserName());
//				emp.setPassword(e.getPassword());
//				emp.setEmail(e.getEmail());
//				emp.setUserRoleId(e.getUserRoleId());
//				emp.setUserRole(getRoles(e.getUserRoleId()));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("outside try ");
		System.out.println("Emp: " + emp.toString());
		return null;
	}

	@Override
	public Reimbursement makeReimbursement(Integer amount, String desc, Integer empId, Integer reimbType) {
		// TODO Auto-generated method stub
		Reimbursement temp = new Reimbursement();
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			con.setAutoCommit(false);
			System.out.println("In reimbursement " +amount + " "+ desc + " "+ empId + " "+ reimbType);
			String key[] = { "REIMB_ID", "REIMB_SUBMITTED" };
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID, REIMB_SUBMITTED) VALUES (?, ?, ?, 1, ?, CURRENT_TIMESTAMP)";	
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setInt(1, amount);
			ps.setString(2, desc);
			ps.setInt(3, empId);
			ps.setInt(4, reimbType);
			ps.executeUpdate();
			//ps.setTimestamp(5, Timestamp.from(java.time.Instant.now()));
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {

				temp.setReimbId(rs.getInt(1));
				temp.setReimbSubmitted(rs.getTimestamp(2).toString());
//				try {
//					temp.setReimbResolved(rs.getTimestamp(3).toString());
//					}
//					catch(NullPointerException e) {
//						temp.setReimbResolved("null");
//					}
//					temp.setReimbDescription(rs.getString(4));
//					temp.setReimbAuthor(rs.getInt(5));
//					try {
//					temp.setReimbReceipt(rs.getBlob(6).toString());
//					}
//					catch(NullPointerException e) {
//						temp.setReimbReceipt("null");
//					}
//					temp.setReimbResolver(rs.getInt(7));
//					temp.setReimbStatId(rs.getInt(8));
//					temp.setReimbTypeId(rs.getInt(9));
			}
			
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return temp;
	}

	@Override
	public Reimbursement updateReimbursement(Integer reiId, Integer reiStat, Integer resoId) {
		// TODO Auto-generated method stub
		Reimbursement temp = new Reimbursement();
		try (Connection con = ConnectionFactory.getInstance().getConnection()) {
			con.setAutoCommit(false);
		String sql = "{call RESOLVE_REIMB(?, ?, ?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, resoId);
		cs.setInt(2, reiStat);
		cs.setInt(3, reiId);
		cs.execute();
		ResultSet rs = cs.getResultSet();
		while(rs.next()) {
			temp.setReimbId(rs.getInt(1));
			temp.setReimbAmount(rs.getInt(2));
			try {
			temp.setReimbResolved(rs.getTimestamp(3).toString());
			}
			catch(NullPointerException e) {
				temp.setReimbResolved("null");
			}
			temp.setReimbDescription(rs.getString(4));
			temp.setReimbAuthor(rs.getInt(5));
			try {
			temp.setReimbReceipt(rs.getBlob(6).toString());
			}
			catch(NullPointerException e) {
				temp.setReimbReceipt("null");
			}
			temp.setReimbResolver(rs.getInt(7));
			temp.setReimbStatId(rs.getInt(8));
			temp.setReimbTypeId(rs.getInt(9));
			temp.setReimbSubmitted(rs.getTimestamp(10).toString());
			
		}
//		ResultSet rs = cs.getGeneratedKeys();
//		while(rs.next()) {
//			
//		}
		con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReById(Integer reimbursementId) {
		// TODO Auto-generated method stub
		ArrayList<Reimbursement> r = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT T2.REIMB_ID, T2.REIMB_AMOUNT, T2.REIMB_RESOLVED, T2.REIMB_DESCRIPTION, T2.REIMB_AUTHOR, T2.REIMB_RECEIPT, T2.REIMB_RESOLVER, T2.REIMB_STATUS_ID, T2.REIMB_TYPE_ID,\r\n" + 
					"T2.REIMB_SUBMITTED, T1.USER_FIRST_NAME, T1.USER_LAST_NAME, T4.REIMB_STATUS, T5.REIMB_TYPE, T3.USER_LAST_NAME AS RESOLVER\r\n" + 
					"FROM ERS_USERS T1\r\n" + 
					"INNER JOIN  ERS_REIMBURSEMENT T2\r\n" + 
					"ON T1.ERS_USERS_ID = T2.REIMB_AUTHOR\r\n" + 
					"LEFT JOIN ERS_USERS T3\r\n" + 
					"ON T2.REIMB_RESOLVER = T3.ERS_USERS_ID\r\n" + 
					"LEFT JOIN ERS_REIMBURSEMENT_STATUS T4\r\n" + 
					"ON T2.REIMB_STATUS_ID = T4.REIMB_STATUS_ID\r\n" + 
					"LEFT JOIN ERS_REIMBURSEMENT_TYPE T5\r\n" + 
					"ON T2.REIMB_TYPE_ID = T5.REIMB_TYPE_ID WHERE T1.ERS_USERS_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reimbursementId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getInt(2));
				try {
				temp.setReimbResolved(rs.getTimestamp(3).toString());
				}
				catch(NullPointerException e) {
					temp.setReimbResolved("null");
				}
				temp.setReimbDescription(rs.getString(4));
				temp.setReimbAuthor(rs.getInt(5));
				try {
				temp.setReimbReceipt(rs.getBlob(6).toString());
				}
				catch(NullPointerException e) {
					temp.setReimbReceipt("null");
				}
				temp.setReimbResolver(rs.getInt(7));
				temp.setReimbStatId(rs.getInt(8));
				temp.setReimbTypeId(rs.getInt(9));
				temp.setReimbSubmitted(rs.getTimestamp(10).toString());
				temp.setAuthor(rs.getString(11) + " " + rs.getString(12));
				temp.setrStat(rs.getString(13));
				temp.setrType(rs.getString(14));
				temp.setResolver(rs.getString(15));
				r.add(temp);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public Employee getUserById(Integer uId) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		try (Connection con = ConnectionFactory.getInstance().getConnection()) {
		String sql = "SELECT A.ERS_USERS_ID, A.ERS_USERNAME, A.ERS_PASSWORD, A.USER_FIRST_NAME, A.USER_LAST_NAME, A.USER_EMAIL, A.USER_ROLE_ID, B.USER_ROLE FROM ERS_USERS A LEFT JOIN ERS_USER_ROLES B ON A.USER_ROLE_ID = B.ERS_USER_ROLE_ID\r\n" + 
				"WHERE A.ERS_USERS_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, uId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			e1.setUserId(rs.getInt(1));
			e1.setUserName(rs.getString(2));
			e1.setPassword(rs.getString(3));
			e1.setFirstName(rs.getString(4));
			e1.setLastName(rs.getString(5));
			e1.setEmail(rs.getString(6));
			e1.setUserRoleId(rs.getInt(7));
//			e1.setUserRole(rs.getString(8));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e1;
	}

	@Override
	public Boolean valEmail(String email) {
		// TODO Auto-generated method stub
		try (Connection con = ConnectionFactory.getInstance().getConnection()) {
		String sql = "select count(user_email) from ers_users where user_email = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if (rs.getInt(1) > 0) {
				return true;
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}



	@Override
	public String getRoles(Integer RId) {
		try (Connection con = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select ROLE from USER_ROLES where ROLE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, RId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
