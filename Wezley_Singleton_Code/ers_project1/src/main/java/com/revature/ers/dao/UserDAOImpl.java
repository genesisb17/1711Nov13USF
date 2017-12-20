package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.ers.pojos.User;
import com.revature.ers.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public User addUser(User newUser) {

		System.out.println("[LOG] - In UserDAOImpl - addUser()...");
		System.out.println(newUser);
		
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			System.out.println("[LOG] - Inside try-block of UserDAOImpl.addUser()...");
			
			conn.setAutoCommit(false);

			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_firstname, user_lastname, user_emailaddress, user_role_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newUser.getUsername());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getFirstName());
			pstmt.setString(4, newUser.getLastName());
			pstmt.setString(5, newUser.getEmailAddress());
			pstmt.setInt(6, newUser.getRoleId());

			System.out.println("[LOG] - PreparedStatement loaded, preparing to execute update...");
			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				
				conn.commit();
				user = getUserByUsername(newUser.getUsername());

				System.out.println("[LOG] - New user created! Id: " + user.getUserId());
			}
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return user;

	}

	@Override
	public User getUserById(int userId) {

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM ers_users WHERE ers_userid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmailAddress(rs.getString(6));
				user.setRoleId(rs.getInt(7));	
			}
		}

		catch(SQLException sqle) {
			sqle.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserByUsername(String username) {

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmailAddress(rs.getString(6));
				user.setRoleId(rs.getInt(7));	
			}
		}

		catch(SQLException sqle) {
			sqle.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserByEmailAddress(String emailAddress) {

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM ers_users WHERE user_emailaddress = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emailAddress);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmailAddress(rs.getString(6));
				user.setRoleId(rs.getInt(7));	
			}
		}

		catch(SQLException sqle) {
			sqle.printStackTrace();
		}

		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {

		ArrayList<User> users = new ArrayList<User>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM ers_users";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmailAddress(rs.getString(6));
				temp.setRoleId(rs.getInt(7));
				users.add(temp);
			}
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return users;
	}

	@Override
	public ArrayList<User> getUsersByRole(int roleId) {

		ArrayList<User> users = new ArrayList<User>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM ers_users WHERE user_role_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roleId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmailAddress(rs.getString(6));
				temp.setRoleId(rs.getInt(7));
				users.add(temp);
			}
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return users;
	}

	@Override
	public User updateUser(int userId, User user) {

		User updatedUser = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);

			String sql = "UPDATE ers_users SET ers_username = ?, ers_password = ?, user_firstname = ?, user_lastname = ?, "
					+ "user_emailaddress = ?, user_roleid = ? WHERE ers_userid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getEmailAddress());
			pstmt.setInt(6, user.getRoleId());
			pstmt.setInt(7, userId);

			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				updatedUser = getUserById(userId);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return updatedUser;
	}
	
	@Override
	public User updateUsernameByUserId(int userId, String username) {

		User updatedUser = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);

			String sql = "UPDATE ers_users SET ers_username = ? WHERE ers_userid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, userId);

			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				updatedUser = getUserById(userId);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return updatedUser;
	}
	
	@Override
	public User updateEmailAddressByUserId(int userId, String emailAddress) {

		User updatedUser = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);

			String sql = "UPDATE ers_users SET user_emailaddress = ? WHERE ers_userid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emailAddress);
			pstmt.setInt(2, userId);

			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				updatedUser = getUserById(userId);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return updatedUser;
	}
	
	@Override
	public User updatePasswordByUserId(int userId, String password) {

		User updatedUser = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);

			String sql = "UPDATE ers_users SET ers_password = ? WHERE ers_userid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, userId);

			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				updatedUser = getUserById(userId);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return updatedUser;
	}
}
