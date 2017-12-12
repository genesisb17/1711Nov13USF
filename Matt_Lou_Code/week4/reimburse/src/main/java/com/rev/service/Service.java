package com.rev.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.ex.util.ConnectionFactory;
import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.Users;

public class Service {
	static DAO dao = new FileDAO();
	
	public Users validateUsername(String username) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select ERS_USERNAME from ERS_USERS";
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				if(rs.getString(1).equals(username)) {
					return null;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Users validateEmail(String email) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select USER_EMAIL from ERS_USERS";
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				//System.out.println(rs.getString(1));
				if(rs.getString(1).equals(email)) {
					return null;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Users addUser(Users u) {
		// validate that username does not exist
		// assuming that it does not exist:
		dao.addUser(u);
		return u;
	}
	
	public Users callUpdate(Users u, Reimbursement reimb) {
		dao.update(u, reimb);
		return u;
	}
	
	public ArrayList<Reimbursement> getdata(){
		return dao.getTable();
		
	}
	
	
	public Users login(String username, String password) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			System.out.println("in login service");
			String sql = "select * from ERS_USERS where ERS_USERNAME = ? and "
					+ "ERS_PASSWORD = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			System.out.println("login service2");
			
			boolean found = false;
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				if(result.getString(2).equals(username) && 
						result.getString(3).equals(password)) {
					found = true;
					user.setUsers_id(result.getInt(1));
					user.setFirstname(result.getString(4));
					user.setLastname(result.getString(5));
					user.setEmail(result.getString(6));
					user.setUserRoleId(result.getInt(7));
					return user;
				}
				
//				else if(!found) {
//					System.out.println("User information is incorrect or DNE");
//				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Users register(String username, String password, String firstname, String lastname,
			String email, int roleId) {
	
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "select ERS_USERNAME from ERS_USERS";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				if(result.getString(2) == username) {
					// user already exists
					System.out.println("username already exists.");
					return null;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Users user = new Users(username, password, firstname, lastname, email, roleId);
		addUser(user);
		return user;
	}
	
	public void submitRequest(double amount, String description, int authorId, int typeId) {
		//Users user = new Users();
		//Reimbursement reimb = new Reimbursement();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			connect.setAutoCommit(false);
			String sql = "insert into ers_reimbursement(reimb_amount, reimb_description,"
					+ " reimb_author, reimb_type_id)" + 
					"values(?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			System.out.println("submit req in service");

			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setInt(3, authorId);
			ps.setInt(4, typeId);
			
			ps.executeUpdate();
			connect.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Users updateReimbursement(int resolver, int status, int reimb_id) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVER = ?, REIMB_STATUS_ID = ?"
					+ "WHERE REIMB_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, resolver);
			ps.setInt(2, status);
			ps.setInt(3, reimb_id);
			
			int row = ps.executeUpdate();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}
			
}






