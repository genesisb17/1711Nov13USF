package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;
import util.ConnectionFactory;

public class DAOImpl implements DAO{

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
				return usr;
			}
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				usr.setId(rs.getInt(1));
				usr.setUsername(rs.getString(2));
				usr.setFirstname(rs.getString(4));
				usr.setLastname(rs.getString(5));
				usr.setEmail(rs.getString(6));
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

	public User getUser(String username) {
		User usr = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_USERS where ers_username = (?) OR user_email = (?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
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

}
