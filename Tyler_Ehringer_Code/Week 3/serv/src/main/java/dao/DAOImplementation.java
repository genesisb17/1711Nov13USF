package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Account;
import pojos.User;
import util.ConnectionFactory;

public class DAOImplementation implements DAO{
	
	public User getUser(String email) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from users where email = ?");
			ps.setString(1, email.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean hasUser(String email) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from users where email = ?");
			ps.setString(1, email.toLowerCase());
			if(ps.executeQuery().next()) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> getAccounts(User u) {
		List<Account> accounts = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("select a.account_id, a.balance from accounts a" +
					" join users_accounts ua on a.account_id = ua.account_id where ua.user_id = ?");
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) accounts.add(new Account(rs.getInt(1), rs.getDouble(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public User addUser(String email, String password, String fname, String lname) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String[] keys = {"user_id"};
			PreparedStatement ps = conn.prepareStatement("insert into users (email, password, first_name, last_name) values (?, ?, ?, ?)", keys);
			ps.setString(1, email.toLowerCase());
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) u = new User(rs.getInt(1), email, password, fname, lname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Account addAccount(User u) {
		Account a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String[] keys = {"account_id"};
			PreparedStatement ps = conn.prepareStatement("insert into accounts (balance) values (0.0)", keys);
			if(ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int accountId = rs.getInt(1);
					a = new Account(accountId, 0.0f);
					PreparedStatement ps2 = conn.prepareStatement("insert into users_accounts (user_id, account_id) values (?, ?)");
					ps2.setInt(1, u.getId());
					ps2.setInt(2, accountId);
					if(ps2.executeUpdate() > 0) {
						conn.commit();
						a = new Account(accountId, 0.0f);
					}else conn.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Account depositToAccount(Account a, double deposit) {
		Account acc = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("update accounts set balance = balance + ? where account_id = ?");
			ps.setDouble(1, deposit);
			ps.setInt(2, a.getId());
			if(ps.executeUpdate() > 0) {
				acc = new Account(a.getId(), a.getBalance() + deposit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public Account addUserToAccount(Account a, User u) {
		Account acc = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into users_accounts (user_id, account_id) values (?, ?)");
			ps.setInt(1, u.getId());
			ps.setInt(2, a.getId());
			if(ps.executeUpdate() > 0) acc = a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	
	
}
