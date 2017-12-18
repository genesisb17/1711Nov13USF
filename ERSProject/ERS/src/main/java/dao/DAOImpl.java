package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import pojos.DTO;
import pojos.User;
import util.ConnectionFactory;

public class DAOImpl implements DAO{
	static Calendar calendar = Calendar.getInstance();

	public User getUser(String username, String password) {
		User usr = new User();
		System.out.println("Before connection to database in get user function");
		System.out.println("username " + username);
		System.out.println("passowrd " + password);
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("in database connection");
			String sql = "select * from ERS_USERS where ers_username = (?) AND ers_password = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			System.out.println("After database sql execution");
			if(!rs.isBeforeFirst()) {
				System.out.println("Inside the clause when theres no result set");
				System.out.println("User values are " + usr.getId() + " " + usr.getUsername());
				return usr;
			}
			else {
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				usr.setId(rs.getInt(1));
				usr.setUsername(rs.getString(2));
				usr.setFirstname(rs.getString(4));
				usr.setLastname(rs.getString(5));
				usr.setEmail(rs.getString(6));
				usr.setUserroleid(rs.getInt(7));
			}
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usr;
	}

	public User getUserById(int id) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select * from ERS_USERS where ers_users_ID = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet userInfo = ps.executeQuery();
			while(userInfo.next()) {
				user.setId(userInfo.getInt(1));
				user.setUsername(userInfo.getString(2));
				user.setFirstname(userInfo.getString(4));
				user.setLastname(userInfo.getString(5));
				user.setEmail(userInfo.getString(6));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	public int addUser(String username, String firstname, String lastname, String email, String password) {
		User usr = new User();
		System.out.println(username + firstname + lastname + email + password);
		int empRole = 413;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "Insert into ERS_USERS(ers_username, ers_password, user_first_name, user_last_name, user_email,user_role_id) VALUES(?,?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "ers_users_id";
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstname);
			ps.setString(4, lastname);
			ps.setString(5, email);
			ps.setInt(6,empRole);
			int rows = ps.executeUpdate();
			if(rows!=0) {
				ResultSet primaryKey = ps.getGeneratedKeys();
				while(primaryKey.next()) {
					usr.setId(primaryKey.getInt(1));
				}
				conn.commit();
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usr.getId();
	}

	public int submitReimRequest(DTO submission) {
		int up = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			System.out.println("In submitReimRequest method in DaoImpl");
			System.out.println("DTO content before sql statement is " + submission.getAmount() + " " + submission.getDescription() + " " + submission.getType() + " " + submission.getId());
			String sql = "Insert into ERS_REIMBURSEMENT(REIMB_AMOUNT,REIMB_SUBMITTED, REIMB_DESCRIPTION,REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.sql.Timestamp currentTime = new java.sql.Timestamp(calendar.getTime().getTime());
			ps.setDouble(1, submission.getAmount());
			ps.setTimestamp(2, currentTime);
			ps.setString(3, submission.getDescription());
			ps.setInt(4, submission.getId());
			ps.setInt(5,  0);
			ps.setInt(6, submission.getType());
			int rows = ps.executeUpdate();
			if(rows != 0) {
				System.out.println("Succesfully Inserted!");
				conn.commit();
				up = rows;
			}
			else {
				up = rows;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return up;
	}
	
	public User getUser(String username) {
		User usr = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_USERS where ers_username = (?) OR user_email = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				System.out.println("User id in get get user by email functino" + usr.getId());
				return usr;
			}
			while(rs.next()) {
				usr.setId(rs.getInt(1));
				usr.setUsername(rs.getString(2));
				usr.setFirstname(rs.getString(4));
				usr.setLastname(rs.getString(5));
				usr.setEmail(rs.getString(6));
				usr.setUserroleid(rs.getInt(7));
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usr;
	}

	@Override
	public User updateUser(String username, String firstname, String lastname, String email) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "UPDATE ERS_USERS SET USER_FIRST_NAME = (?), USER_LAST_NAME = (?), USER_EMAIL = (?) WHERE ERS_USERNAME = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, username);
			System.out.println("Before execute update");
			int rows = ps.executeUpdate();
			System.out.println("After update. Rows = " + rows);
			if(rows!=0) {
				System.out.println("Row Updated Succesfully");
				
				u.setFirstname(firstname);
				u.setLastname(lastname);
				u.setEmail(email);
				u.setUsername(username);
				conn.commit();
			}
			else {
				System.out.println("Error: No Row Was Updated.");
				u.setUsername("");
			}
		} catch (SQLException e) {
			System.out.println("Error took place. Check exception");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int updatePassword(String username, String password) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "UPDATE ERS_USERS SET ERS_PASSWORD = (?) WHERE ERS_USERNAME =(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			int rows = ps.executeUpdate();
			if(rows!=0) {
				System.out.println("Row Updated Succesfully");
				conn.commit();
			}
			else {
				System.out.println("Error: No Row Was Updated");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public ArrayList<DTO> getRequests(User u) {
		ArrayList<DTO> data = new ArrayList<DTO>();
		DTO transfer = new DTO();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				transfer.setId(rs.getInt(1));
				transfer.setAmount(rs.getDouble(2));
				transfer.setSubmitted(rs.getTimestamp(3));
				transfer.setResolved(rs.getTimestamp(4));
				transfer.setDescription(rs.getString(5));
				transfer.setCreator(rs.getInt(6));
				transfer.setResolver(rs.getInt(7));
				transfer.setStatus(rs.getInt(8));
				transfer.setType(rs.getInt(9));
				data.add(transfer);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return data;
	}
public ArrayList<DTO> getAllRequests() {
	ArrayList<DTO> data = new ArrayList<DTO>();
	DTO transfer = new DTO();
	try(Connection conn = ConnectionFactory.getInstance().getConnection();){
		String sql = "SELECT * FROM ERS_REIMBURSEMENT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			transfer.setId(rs.getInt(1));
			transfer.setAmount(rs.getDouble(2));
			transfer.setSubmitted(rs.getTimestamp(3));
			transfer.setResolved(rs.getTimestamp(4));
			transfer.setDescription(rs.getString(5));
			transfer.setCreator(rs.getInt(6));
			transfer.setResolver(rs.getInt(7));
			transfer.setStatus(rs.getInt(8));
			transfer.setType(rs.getInt(9));
			data.add(transfer);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return data;
}
}
