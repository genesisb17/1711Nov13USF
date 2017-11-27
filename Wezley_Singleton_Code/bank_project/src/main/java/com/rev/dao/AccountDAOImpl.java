package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rev.pojos.Account;
import com.rev.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account addAccount(Account acct) {
		
		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO accounts (acct_type, balance) "
					+ "VALUES (?, ?)";
			
			String[] key = new String[3];
			key[0] = "acct_id";
			key[1] = "acct_type";
			key[2] = "balance";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, acct.getAcctType());
			pstmt.setDouble(2, acct.getBalance());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					account.setAcctId(rs.getInt(1));
				}
				
				account.setAcctType(acct.getAcctType());
				account.setBalance(acct.getBalance());
				
				conn.commit();
				
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return account;
		
	}

	@Override
	public Account getAccountById(int acctId) {
		
		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM accounts WHERE acct_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acctId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				account.setAcctId(rs.getInt(1));
				account.setAcctType(rs.getString(2));
				account.setBalance(rs.getDouble(3));
				
			}
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return account;
		
	}

	@Override
	public Account updateBalance(int acctId, double newBalance) {
		
		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE accounts SET balance = ? WHERE acct_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, newBalance);
			pstmt.setInt(2, acctId);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				
				conn.commit();
				account = getAccountById(acctId);
				
			}
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return account;
		
	}

}
