package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.ex.pojos.Account;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

public class DAOImpl implements DAO{
	
	public HashMap<Integer, String> getEmails(){
		HashMap<Integer, String> emails = new HashMap<Integer, String>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select userid, email from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt(1);
				String email = rs.getString(2);
				emails.put(id, email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emails;
	}
	
	public User getUserById(int id){
		User u = new User();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select * from users where userid =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				u.setId(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setEmail(info.getString(4));
				u.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	
	public int addUser(String fn, String ln, String email, String pass){
		try(Connection conn  = ConnectionFactory
				.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into users "
					+ "(firstname, lastname, email, password) "
					+ "values(?, ?, ?, ? )";
			String [] key = new String[1];
			key[0] = "u_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, pass);
			
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			
			conn.commit();
			return id;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Account createAccount(User u, int typeId){
		Account a = new Account();
		
		try(Connection conn  = ConnectionFactory
				.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "insert into account(userid, typeid)"
					+ " values (?, ?)";
			String[] key = new String[1];
			key[0] = "accountid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, u.getId());
			ps.setInt(2, typeId);
			
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()){
				id = pk.getInt(1);
			}
			System.out.println("id is " + id);
			a.setId(id);
			a.setBalance(0);
		//	a.setType();
			
			conn.commit();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return a;
	}
	
	public ArrayList<Account> getAccountsByUser(User u){
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select acc.ACCOUNTID, acc.balance, t.name"
					+ " from account acc inner join users on users.userid = acc.userid"
					+ " inner join accounttype t on t.typeid = acc.typeid where users.userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				Account temp = new Account();
				temp.setId(info.getInt(1));
				System.out.println("Account " + temp.getId());
				temp.setBalance(info.getDouble(2));
				temp.setUser(u);
				temp.setType(info.getString(3));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return accounts;
	}
	
	public double getBalance(int id){
		double bal = 0.0;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "select balance from account where accountid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				bal = info.getDouble(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return bal;
	}
	
	
	public void updateBalance(int id, double amt){
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			String sql = "update account set balance = ? where accountid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amt );
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}

	@Override
	public User getUser(String username) {
		User u = new User();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection();){
			username = username.toLowerCase();
			String sql = "select * from users where lower(email) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				u.setId(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setEmail(info.getString(4));
				u.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	
	}
	

}
