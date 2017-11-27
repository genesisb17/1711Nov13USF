package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.pojos.AccountRegistrar;
import com.rev.util.ConnectionFactory;

public class AccountRegistrarDAOImpl implements AccountRegistrarDAO {

	@Override
	public AccountRegistrar registerUserToAccount(AccountRegistrar acctReg) {

		AccountRegistrar accountRegistrar = new AccountRegistrar();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO account_registrar (u_id, acct_id, privilege) "
					+ "VALUES (?, ?, ?)";

			String[] key = new String[3];
			key[0] = "u_id";
			key[1] = "acct_id";
			key[2] = "privilege";

			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setInt(1, acctReg.getUserId());
			pstmt.setInt(2, acctReg.getAcctId());
			pstmt.setString(3, acctReg.getUserPrivilege());

			int rowsUpdated = pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if(rowsUpdated != 0) {

				while(rs.next()) {
					accountRegistrar.setUserId(rs.getInt(1));
					accountRegistrar.setAcctId(rs.getInt(2));
				}

				accountRegistrar.setUserPrivilege(acctReg.getUserPrivilege());

				conn.commit();
			}

		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return accountRegistrar;
	}

	@Override
	public ArrayList<AccountRegistrar> getUsersOnAccount(int acctId) {

		ArrayList<AccountRegistrar> usersOnAccount = new ArrayList<AccountRegistrar>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM account_registrar WHERE acct_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acctId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				AccountRegistrar temp = new AccountRegistrar();
				temp.setUserId(rs.getInt(1));
				temp.setAcctId(rs.getInt(2));
				temp.setUserPrivilege(rs.getString(3));
				usersOnAccount.add(temp);
				
			}
			
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return usersOnAccount;

	}

	@Override
	public ArrayList<AccountRegistrar> getUserAccounts(int userId) {

		ArrayList<AccountRegistrar> userAccounts = new ArrayList<AccountRegistrar>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM account_registrar WHERE u_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				AccountRegistrar temp = new AccountRegistrar();
				temp.setUserId(rs.getInt(1));
				temp.setAcctId(rs.getInt(2));
				temp.setUserPrivilege(rs.getString(3));
				userAccounts.add(temp);
				
			}
			
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return userAccounts;

	}

	@Override
	public void removeUserFromAccount(int userId) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			conn.setAutoCommit(false);
			
			String sql = "DELETE * FROM account_registrar WHERE u_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
			}
			
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
