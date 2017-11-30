package com.rev.dao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.ex.util.ConnectionFactory;
import com.rev.pojos.User;
import com.rev.run.RunBank;
import com.rev.service.Service;

public class FileDAO implements DAO {
	Service service = new Service();
	public User addUser(User u) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD)" + 
					"VALUES(?, ?, ?, ?)";
//			String sql2 = "INSERT INTO ACCOUNTS(ACC_ID, USER_ID, BALANCE)" +
//					"VALUES(?, ?, ?)";
			String sql2 = "INSERT INTO ACCOUNTS(USER_ID, BALANCE)" +
					"VALUES(?, ?)";
			String [] key = {"U_ID"};
			String [] key2 = {"USER_ID"};
			PreparedStatement ps2 = conn.prepareStatement(sql2, key2);
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
			
			int rows = ps.executeUpdate();
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					u.setId(pk.getInt(1));
				}
				user.setFirstname(u.getFirstname());
				user.setLastname(u.getLastname());
				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());
				user.setBalance(u.getBalance());
				conn.commit();
				
			}

			ps2.setInt(1, u.getId());
			ps2.setDouble(2, u.getBalance());
			ps2.executeUpdate();
//			Random rand = new Random();
//			int n = rand.nextInt(100) + 1;

//			if(rows != 0) {
//
//				ResultSet pk2 = ps2.getGeneratedKeys();
//				while(pk2.next()) {
//					ps2.setInt(1, pk2.getInt(1));
//					System.out.println("here4");
//				}
					
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
			
	}

	public User getUser(String username) {
//		User user = new User();
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String sql = "select * from users where U_ID = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, u.getId());
//			ResultSet info = ps.executeQuery();
//			while(info.next()) {
//				user.set
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
		return null;
	}
	
	public User update(User u) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "update accounts set balance = ? where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, u.getBalance());
			ps.setInt(2, u.getId());
			ps.executeUpdate();
			
			//user = getUser(u);		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}








