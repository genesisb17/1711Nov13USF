package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.ers.pojos.Role;
import com.revature.ers.pojos.UserRole;
import com.revature.ers.util.ConnectionFactory;

public class UserRoleDAOImpl implements UserRoleDAO{

	@Override
	public UserRole addUserRole(UserRole newUserRole) {
		
		UserRole userRole = new UserRole();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ers_user_roles (ers_userRole) VALUES (?)";
			
			String[] key = new String[2];
			key[0] = "ers_userRoleId";
			key[1] = "ers_userRole";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, newUserRole.getRole().toString());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					userRole.setRoleId(rs.getInt(1));
				}
				
				userRole.setRole(newUserRole.getRole());
				
				conn.commit();
			}	
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return userRole;
	}

	@Override
	public UserRole getUserRoleById(int roleId) {
		
		UserRole userRole = new UserRole();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_user_roles WHERE ers_userRoleId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roleId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userRole.setRoleId(rs.getInt(1));
				userRole.setRole(Role.valueOf(rs.getString(2)));
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return userRole;
	}
	
	@Override
	public ArrayList<UserRole> getAllUserRoles() {
		
		ArrayList<UserRole> userRoles = new ArrayList<UserRole>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ers_user_roles";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				UserRole temp = new UserRole();
				temp.setRoleId(rs.getInt(1));
				temp.setRole(Role.valueOf(rs.getString(2)));
				userRoles.add(temp);
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return userRoles;
	}

	@Override
	public UserRole updateUserRole(int roleId, UserRole userRole) {
		
		UserRole updatedUserRole = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ers_user_roles SET ers_userRole = ? WHERE ers_userRoleId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userRole.getRole().toString());
			pstmt.setInt(2, roleId);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				updatedUserRole = getUserRoleById(roleId);
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedUserRole;
	}

	@Override
	public void removeUserRole(int roleId) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM ers_user_roles WHERE ers_userRoleId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roleId);
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
	}
}
