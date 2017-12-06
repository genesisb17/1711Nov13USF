package com.ERS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ERS.pojos.USER_ROLE;
import com.ERS.pojos.User;
import com.bank.util.ConnectionFactory;

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
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getEmail());
			//if admin flag, set 
			int role = (admin ? 1 : 0);
			ps.setInt(6, role);
			int rows = ps.executeUpdate();
			//int id = 0;
			
			if(rows !=0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
				//	id = pk.getInt(1);
					u.setUser_id(pk.getInt(1));
			
				}
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	

	@Override
	public User getUser(String username) {
		User user = new User();
		//user.setUser_id(-1);
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
			ResultSet pk = ps.executeQuery();
			System.out.println("before while");
			while(pk.next()) {
				System.out.println("in while");
			//	id = pk.getInt(1);
				user.setUser_id(pk.getInt("ERS_USERS_ID"));
				user.setFirstname(pk.getString("USER_FIRST_NAME"));
				user.setLastname(pk.getString("USER_LAST_NAME"));
				user.setUsername(pk.getString("ERS_USERNAME"));
				user.setPassword(pk.getString("ERS_PASSWORD"));
				user.setEmail(pk.getString("USER_EMAIL"));
				user.setRole((pk.getInt("USER_ROLE_ID") == 0 ? USER_ROLE.EMPLOYEE : USER_ROLE.MANAGER));
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
