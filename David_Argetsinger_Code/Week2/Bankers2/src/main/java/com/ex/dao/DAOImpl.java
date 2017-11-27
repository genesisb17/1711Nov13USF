package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
//import java.sql.Statement;
//import java.util.ArrayList;

import com.ex.pojos.Account;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

public class DAOImpl implements DAO {
/*
	@Override
	public ArrayList<User> getArtists() {
		ArrayList<User> artists = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				artists.add(temp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artists;
	}
*/
	// my update artist
	/*
	 * @Override public Artist updateArtist(int id, String name) { Artist art =
	 * new Artist(); try (Connection conn =
	 * ConnectionFactory.getInstance().getConnection()) {
	 * conn.setAutoCommit(false); String sql =
	 * "update artist set name=(?) where artistid=(?)"; PreparedStatement ps =
	 * conn.prepareStatement(sql); ps.setString(1, name); ps.setInt(2,id); int
	 * rows = ps.executeUpdate();
	 * 
	 * if (rows == 0) return null; conn.commit(); art=getArtistById(id); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return art;
	 * 
	 * }
	 */// class update artist
	
	@Override
	public User getUserByUname(String username) {
		User use = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from USERS where Username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(2));
				use.setUsername((info.getString(4)));
				use.setLastname(info.getString(3));
				use.setPassword((info.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return use;
	}
	
	@Override
	public Account findAH(User user) {
		Account acc= new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Accounts where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				acc.setAccountId(info.getInt(1));
				acc.setUserId(info.getInt(2));
				acc.setBalance(info.getDouble(3));
	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acc;
	}
	
	@Override
	public User getUserById(int id) {
		User use = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from USERS where U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(2));
				use.setUsername((info.getString(4)));
				use.setLastname(info.getString(3));
				use.setPassword((info.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return use;

	}

	@Override
	public boolean addUser(String name, String Lastname, String username, String password) {
		//User use = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS (FIRSTNAME,LASTNAME,USERNAME,PASSWORD) VALUES (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2,Lastname);
			preparedStatement.setString(3,username);
			preparedStatement.setString(4,password);

//			String[] key = new String[5];
//			key[0] = "U_ID";
//			
//			PreparedStatement ps = conn.prepareStatement(sql, key); 
//			ps.setString(1, name);
//			ps.setString(2, Lastname);
//			ps.setString(3, username);
//			ps.setString(4, password);
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
//			int id = 0;
			if (rows != 0) {
//				ResultSet pk = preparedStatement.getGeneratedKeys(); // returns a id key, (and value ) 
//				while (pk.next()) {
//					use.setId(pk.getInt(1)); // returns auto incremented number ! 
//				} // using just execute.? will work with key 
//				use.setName(name);
//				use.setLastname(Lastname);
//				use.setUsername(username);
//				use.setPassword(password);
				conn.commit();
				return true;

			}
		} catch(SQLIntegrityConstraintViolationException e){
			System.out.println("That username already exists. Please try again.");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public User updateAccount(int id, int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User doLogin(String usern, String passw) {
		User use = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from USERS where USERNAME = ? and PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usern);
			ps.setString(2, passw);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				use.setId(info.getInt(1));
				use.setName(info.getString(2));
				use.setUsername((info.getString(4)));
				use.setLastname(info.getString(3));
				use.setPassword((info.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return use;

	}

	@Override
	public boolean updateBal(Account acc, double update) {
		//update customer set firstname='Robert',lastname='Walter' where customerid=32;
			//User use = new User();
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				conn.setAutoCommit(false);
				String sql = "UPDATE ACCOUNTS SET BALANCE=? WHERE ACC_ID=?";
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setDouble(1, update);
				preparedStatement.setInt(2,acc.getAccountId());
				int rows = preparedStatement.executeUpdate();// returns number of rows modified 
				if (rows != 0) {
					conn.commit();
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return false;

		}

	@Override
	public boolean addAccount(User user, double initial) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ACCOUNTS (USER_ID,BALANCE) VALUES (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setDouble(2,initial);
			int rows = preparedStatement.executeUpdate();// returns number of rows modified 
			if (rows != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return false;
	}
	





	// @Override
	// public User updateArtist(int id, String name) {
	// User art =new User();
	// try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
	// String sql = "update artist set name=(?) where artistid=(?)";
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setString(1, name);
	// ps.setInt(2,id);
	// ps.executeUpdate();
	// art=getArtistById(id);
	// //doesn't need commit false because true is default
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return art;
	// }

}