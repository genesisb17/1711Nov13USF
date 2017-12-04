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

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);

			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_firstname, user_lastname, user_emailaddress, user_role_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			String[] key = new String[7];
			key[0] = "ers_userid";
			key[1] = "ers_username";
			key[2] = "ers_password";
			key[3] = "user_firstname";
			key[4] = "user_lastname";
			key[5] = "user_emailaddress";
			key[6] = "user_role_id";

			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, newUser.getUsername());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getFirstName());
			pstmt.setString(4, newUser.getLastName());
			pstmt.setString(5, newUser.getEmailAddress());
			pstmt.setInt(6, newUser.getRoleId());

			int rowsUpdated = pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					user.setUserId(rs.getInt(1));
				}

				user.setUsername(newUser.getUsername());
				user.setPassword(newUser.getPassword());
				user.setFirstName(newUser.getFirstName());
				user.setLastName(newUser.getLastName());
				user.setEmailAddress(newUser.getEmailAddress());
				user.setRoleId(newUser.getRoleId());

				conn.commit();
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
					+ "user_emailaddress = ?, user_roleid = ? WHERE u_id = ?";

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
}
