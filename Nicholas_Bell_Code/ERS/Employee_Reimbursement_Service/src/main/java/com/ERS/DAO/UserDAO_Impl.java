package com.ERS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ERS.pojos.USER_ROLE;
import com.ERS.pojos.User;
import com.ERS.util.ConnectionFactory;

public class UserDAO_Impl implements UserDAO{

	@Override
	public User addUser(User u, boolean admin) {
		User user =  new User(u);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			
			String sql = "insert into ERS_USERS (USER_FIRST_NAME,USER_LAST_NAME,ERS_USERNAME,"
					+ "ERS_PASSWORD,USER_EMAIL,USER_ROLE_ID) "
					+ "values (?,?,?,?,?,?)";
			String[] key= new String[1];
			key[0] = "ERS_USERS_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			//if admin flag, set 
			int role = (admin ? 1 : 0);
			ps.setInt(6, role);
			int rows = ps.executeUpdate();
			//int id = 0;
			
			if(rows !=0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
				//	id = pk.getInt(1);
					user.setUser_id(pk.getInt(1));
			
				}
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	

	@Override
	public User getUserbyUN(String username) {
		User user = new User();
		user.setUser_id(-1);
		try(Connection conn = 
				ConnectionFactory.getInstance().getConnection();){
			//conn.setAutoCommit(false);
			
			String sql = "select * from ERS_USERS "
					+ "where ERS_USERNAME = (?)";
			System.out.println("inDAO username = " + username);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			//int rows = ps.executeUpdate();
			//int id = 0;
			
			//if(rows !=0) {
			ResultSet rs = ps.executeQuery();
			System.out.println("before while");
			
			//isBeforeFirst returns false if no rows
			if(!rs.isBeforeFirst()) {
				user = null;
			}
			else {
				while(rs.next()) {
					System.out.println("in while");
				//	id = pk.getInt(1);
					user.setUser_id(rs.getInt("ERS_USERS_ID"));
					user.setFirstname(rs.getString("USER_FIRST_NAME"));
					user.setLastname(rs.getString("USER_LAST_NAME"));
					user.setUsername(rs.getString("ERS_USERNAME"));
					user.setPassword(rs.getString("ERS_PASSWORD"));
					user.setEmail(rs.getString("USER_EMAIL"));
					user.setRole((rs.getInt("USER_ROLE_ID") == 0 ? false : true));
				}
			}
				//conn.commit();
			//}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUserbyEMAIL(String email) {
		User user = new User();
		user.setUser_id(-1);
		try(Connection conn = 
				ConnectionFactory.getInstance().getConnection();){
			//conn.setAutoCommit(false);
			
			String sql = "select * from ERS_USERS "
					+ "where USER_EMAIL = (?)";
			System.out.println("inDAO email = " + email);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			//int rows = ps.executeUpdate();
			//int id = 0;
			
			//if(rows !=0) {
			ResultSet rs = ps.executeQuery();
			System.out.println("before while");
			
			//isBeforeFirst returns false if no rows
			if(!rs.isBeforeFirst()) {
				user = null;
			}
			else {
				while(rs.next()) {
					System.out.println("in while");
				//	id = pk.getInt(1);
					user.setUser_id(rs.getInt("ERS_USERS_ID"));
					user.setFirstname(rs.getString("USER_FIRST_NAME"));
					user.setLastname(rs.getString("USER_LAST_NAME"));
					user.setUsername(rs.getString("ERS_USERNAME"));
					user.setPassword(rs.getString("ERS_PASSWORD"));
					user.setEmail(rs.getString("USER_EMAIL"));
					user.setRole((rs.getInt("USER_ROLE_ID") == 0 ? false : true));
				}
			}
				//conn.commit();
			//}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
