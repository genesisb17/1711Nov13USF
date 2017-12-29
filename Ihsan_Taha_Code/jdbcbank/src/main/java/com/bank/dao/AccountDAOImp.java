package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class AccountDAOImp implements AccountDAO
{

	@Override
	public ArrayList<Account> getAllAccounts(User user)
	{
		ArrayList<Account> accounts = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Account temp = new Account();
				temp.setAccountId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				accounts.add(temp);
			}
		} catch (SQLException e)
		{
			// e.printStackTrace();
			return null;
		}

		return accounts;
	}

	@Override
	public ArrayList<Account> getAccountsByUserId(User user)
	{
		return null;
	}

	@Override
	public Account addAccount(User user)
	{
		Account acc = new Account();
		acc.setBalance(0.0);

		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?,?)";
			String[] key = new String[1];
			key[0] = "ACC_ID";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setInt(1, user.getUserId());
			ps.setDouble(2, acc.getBalance());

			int rows = ps.executeUpdate();
			if (rows != 0)
			{
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next())
				{
					acc.setAccountId(rs.getInt(1));
					acc.setUserId(rs.getInt(2));
					acc.setBalance(rs.getDouble(3));
				}

				conn.commit();
			}

		} catch (SQLException e)
		{
			// e.printStackTrace();
		}

		if (acc.getAccountId() != 0)

			return acc;
		else
			return null;
	}

	@Override
	public Account getAccount(int acc_id)
	{
		Account account = new Account();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "SELECT * FROM ACCOUNTS WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acc_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				account.setAccountId(rs.getInt(1));
				account.setUserId(rs.getInt(2));
				account.setBalance(rs.getDouble(3));
			}
		} catch (SQLException e)
		{
			// e.printStackTrace();
			return null;
		}

		if (account.getAccountId() == 0)
			return null;
		else
			return account;
	}

	@Override
	public void updateAccount(Account account)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setDouble(2, account.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(int acc_id)
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "DELETE FROM ACCOUNTS WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acc_id);
			ps.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}