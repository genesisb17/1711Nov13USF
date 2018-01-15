package com.reimb.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.reimb.pojos.Reimburse;
import com.reimb.pojos.ReimburseLog;
import com.reimb.pojos.User;
import com.reimb.util.ConnectionFactory;

public class DAOImpl implements DAO {
	public User getUserById(int id) {
		return null;
	}

	public User getUserByEmail(String email){
		User use = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_USERS where USER_EMAIL = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(4));
				use.setUsername((info.getString(2)));
				use.setLastname(info.getString(5));
				use.setPassword((info.getString(3)));
				use.setEmail(info.getString(6));
				use.setRole(info.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return use;
	}


	public User updateAccount(User user){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE ERS_USERS SET USER_FIRST_NAME=?,USER_LAST_NAME=?,ERS_PASSWORD=?,USER_EMAIL=? WHERE ERS_Username=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());	
			preparedStatement.setString(2, user.getLastname());	
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getUsername());
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			if (rows != 0) {
				conn.commit();
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	public User getUserByUname(String username) {
		User use = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ERS_USERS where ERS_Username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(4));
				use.setUsername((info.getString(2)));
				use.setLastname(info.getString(5));
				use.setPassword((info.getString(3)));
				use.setEmail(info.getString(6));
				use.setRole(info.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return use;
	}

	public User doLogin(String usern, String passw) {
		return null;
	}
	
	public boolean updateRiemb (Reimburse reimb){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql="UPDATE ERS_REIMBURSEMENT SET  REIMB_STATUS_ID=?,REIMB_RESOLVER=? where REIMB_ID=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, reimb.getType()); //stored status in type, whoops 
			preparedStatement.setInt(2,reimb.getResolver());
			preparedStatement.setInt(3,reimb.getId());
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			if (rows != 0) {
				conn.commit();
				return true;

			}
		} catch(SQLIntegrityConstraintViolationException e){
			System.out.println("Constraint breaking aborted.");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//not in table
		return false;



	}


	public boolean addReimb(Reimburse reimb){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID,REIMB_DESCRIPTION)VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setDouble(1, reimb.getAmount());
			preparedStatement.setInt(2,reimb.getAuthor());
			preparedStatement.setInt(3,reimb.getStatus());
			preparedStatement.setInt(4,reimb.getType());
			preparedStatement.setString(5,reimb.getDesc());
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			if (rows != 0) {
				conn.commit();
				return true;
			}
		} catch(SQLIntegrityConstraintViolationException e){
			System.out.println("Constaint breaking aborted.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean addUser(String name, String Lastname, String username, String password,String email, int role) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS (USER_FIRST_NAME,USER_LAST_NAME,ERS_USERNAME,ERS_PASSWORD,USER_EMAIL,USER_ROLE_ID) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2,Lastname);
			preparedStatement.setString(3,username);
			preparedStatement.setString(4,password);
			preparedStatement.setString(5,email);
			preparedStatement.setInt(6,role);
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			if (rows != 0) {
				conn.commit();
				return true;
			}
		} catch(SQLIntegrityConstraintViolationException e){
			System.out.println("That username already exists. Please try again.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public ArrayList<ReimburseLog> getReimb(){ 
		ArrayList<ReimburseLog> reimbs = new ArrayList<ReimburseLog>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select reimb.REIMB_ID,u.ERS_USERNAME,u.USER_FIRST_NAME,u.USER_LAST_NAME,s.REIMB_STATUS,reimb.REIMB_AMOUNT,reimb.REIMB_DESCRIPTION,"
					+ "ty.REIMB_TYPE,reimb.REIMB_SUBMITTED,u2.ers_username,reimb.REIMB_RESOLVED from ERS_REIMBURSEMENT reimb "
					+ "inner join ERS_USERS u on u.ERS_USERS_ID = reimb.REIMB_AUTHOR "
					+ "left join ers_users u2 on  u2.ers_users_id = reimb.REIMB_RESOLVER "
					+ "inner join ERS_REIMBURSEMENT_STATUS s on s.REIMB_STATUS_ID=reimb.REIMB_STATUS_ID "
					+ "inner join ERS_REIMBURSEMENT_TYPE ty on ty.REIMB_TYPE_ID=reimb.REIMB_TYPE_ID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			while(info.next()){
				ReimburseLog temp = new ReimburseLog();
				temp.setId(info.getInt(1));
				temp.setUsername(info.getString(2));
				temp.setFname(info.getString(3));
				temp.setLname(info.getString(4));
				temp.setRstatus(info.getString(5));
				temp.setAmount(info.getDouble(6));
				temp.setDesc(info.getString(7));
				temp.setRtype(info.getString(8));
				temp.setDate(format.format(info.getTimestamp(9)));
				temp.setResolver(info.getString(10));
				if(info.getTimestamp(11)!=null)
					temp.setResolved(format.format(info.getTimestamp(11)));
				else
					temp.setResolved(null);//grab the null don't convert it
				reimbs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}


	public ArrayList<Reimburse> getReimbByUser(User u){
		ArrayList<Reimburse> reimbs = new ArrayList<Reimburse>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select * from ERS_REIMBURSEMENT reimb inner "
					+ "join ERS_USERS u on u.ERS_USERS_ID = "
					+ "reimb.REIMB_AUTHOR where u.ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			while(info.next()){
				Reimburse temp = new Reimburse();
				temp.setId(info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(format.format(info.getTimestamp(3)));
				if(info.getTimestamp(4)!=null)
					temp.setResolved(format.format(info.getTimestamp(4)));
				else
					temp.setResolved(null);//grab the null don't convert it
				temp.setDesc(info.getString(5));
				temp.setReceipt(info.getBlob(6));
				temp.setAuthor(info.getInt(7));
				temp.setResolver(info.getInt(8));
				temp.setStatus(info.getInt(9));
				temp.setType(info.getInt(10));
				reimbs.add(temp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

}