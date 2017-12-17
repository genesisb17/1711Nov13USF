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
import com.rev.pojos.ReimbursementNames;
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
				if(rs.getString(1).equals(email)) {
					return null;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/*
	 * function is added with the register function to add user to the database
	 */
	public Users addUser(Users u) {
		// validate that username does not exist
		// assuming that it does not exist:
		dao.addUser(u);
		return u;
	}
	
	/*
	 * function is called in the service layer to update the status of reimbursement 
	 */
	public void callUpdate(int user_id, int status_id, int reimb_id) {
		dao.update(user_id, status_id, reimb_id);
	}
	
	/*
	 *  function is called in the service layer get the data for manager table
	 */
	public ArrayList<ReimbursementNames> getdata(){
		return dao.getTable();
		
	}
	
	
	public Users login(String username, String password) {
		Users user = new Users();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){

			String sql = "select * from ERS_USERS where ERS_USERNAME = ? and "
					+ "ERS_PASSWORD = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			
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
				

				else if(!found) {
					return null;
				}
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
					/*
					 *  user already exists, return null so that the front-end knows that 
					 *  null means that user exist, display the message for the user
					 *  to choose another username at the front end.
					 */
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
	
	/*
	 * an employee can submit a request with amount, description, authorId, and typeId
	 * from the front end.
	 */
	
	public void submitRequest(double amount, String description, int authorId, int typeId) {
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			connect.setAutoCommit(false);
			String sql = "insert into ers_reimbursement(reimb_amount, reimb_description,"
					+ " reimb_author, reimb_type_id)" + 
					"values(?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);

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
	
	/*
	 *  function for employee to return an arraylist of the reimbursements that 
	 *  the user submitted, each individual with different user_id will get
	 *  their own table, based on how many reimbursement requests were sent
	 */
	public ArrayList<ReimbursementNames> getUserViewData(int user_id){
		ArrayList<ReimbursementNames> arr = new ArrayList<ReimbursementNames>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){

			String sql = "select reimb.reimb_id, reimb.reimb_amount, reimb.reimb_submitted," + 
					"reimb.reimb_resolved, reimb.reimb_description," + 
					"reimb.reimb_status_id, reimb.reimb_type_id," + 
					"u.user_first_name, u.user_last_name from ers_reimbursement reimb " + 
					"inner join ers_users u on reimb.reimb_author = u.ers_users_id " + 
					"where u.ERS_USERS_ID=?";
			
			// statement to select firstname and lastname from reimbursement author id
			PreparedStatement ps = connect.prepareStatement(sql);
		
			ps.setInt(1, user_id);
			
			
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()) {
				ReimbursementNames reimb = new ReimbursementNames();
				reimb.setReimb_id(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getTimestamp(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setStatus_id(rs.getInt(6));
				reimb.setType_id(rs.getInt(7));
				reimb.setFirst_name(rs.getString(8));
				reimb.setLast_name(rs.getString(9));
				arr.add(reimb);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	/*
	 * update the profile of the user, the user is able to change their firstname,
	 * lastname, and email; email is validated from the front-end via ajax to make
	 * sure that the email does not exist yet
	 */
	public void updateProfile(int id, String firstname, String lastname, String email) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			connect.setAutoCommit(false);
			String sql = "update ers_users set user_first_name = ?, " + 
					"user_last_name = ?, user_email = ? " + 
					"where ers_users_id = ?";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setInt(4, id);
			ps.executeUpdate();
			connect.commit();			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
}






