package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.jdbc.ConnectionFactory;
import com.bank.main.MainDriver;
import com.bank.pojos.Accounts;
import com.bank.pojos.Users;

public class DAOimpl implements DAO{

	@Override
	public Users addUser(ArrayList<String> input) {
		// TODO Auto-generated method stub
		Users u = new Users(input.get(0), input.get(1), input.get(2).toLowerCase(), input.get(3));
		Accounts a = new Accounts();
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			con.setAutoCommit(false);
			String sql = "INSERT INTO Users (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "U_ID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
			u.setId(rs.getInt(1));
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("\nUsername must be unique.\n"
					+ "Try again.\n");
			u = null;
			System.out.println("Welcome to DE Bank!");
			System.out.println("Would you like to CREATE(1) an account, LOGIN(2) or \n"
					+ "EXIT(3)?");
			MainDriver.run();

		}
		
		if(!(u == null)) {
			a.setuId(u.getId());
		
		//setting the initial balance
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//setting account table user id to user table user id

			conn.setAutoCommit(false);
			String sql2 = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?, ?)";
			String[] a_key = new String[1];
			a_key[0] = "ACC_ID";
			PreparedStatement ps2 = conn.prepareStatement(sql2, a_key);
			ps2.setInt(1, a.getuId());
			ps2.setDouble(2, 0.0);
			ps2.executeUpdate();
			ResultSet rs2 = ps2.getGeneratedKeys();
			while(rs2.next()) {
			a.setAcctId(rs2.getInt(1));
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Congratulations. Successfully created a new user.");
		}
		return u;
	}

	@Override
	public Users logOn(String un, String pwd) {
		// TODO Auto-generated method stub
		Users u = new Users();
		try(Connection con = ConnectionFactory.getInstance().getConnection()) {
			//con.setAutoCommit(false);
			String sql = "SELECT * FROM USERS WHERE USERNAME = (?) AND PASSWORD = (?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, un.toLowerCase());
			prep.setString(2, pwd);
			
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(5));
			}

			//con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u;
		
	}


	@Override
	public Accounts addAccount(Integer uid) {
		// TODO Auto-generated method stub
		Accounts a = new Accounts();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql2 = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?, ?)";
			String[] a_key = new String[1];
			a_key[0] = "ACC_ID";
			PreparedStatement ps2 = conn.prepareStatement(sql2, a_key);
			ps2.setInt(1, uid);
			ps2.setDouble(2, 0.0);
			ps2.executeUpdate();
			ResultSet rs2 = ps2.getGeneratedKeys();
			while(rs2.next()) {
			a.setAcctId(rs2.getInt(1));
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nNew Bank account created! Please view details from the menu.\n");
		return a;
	}

	@Override
	public ArrayList<Integer> acctDetails(Integer cred) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> a_ids = new ArrayList<>();
		ArrayList<Double> a_bal = new ArrayList<>();
		String[] us = new String[2];
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql2 = "SELECT * FROM ACCOUNTS A INNER JOIN USERS U ON A.USER_ID = U.U_ID WHERE A.USER_ID = (?)";
			String[] a_key = new String[1];
			a_key[0] = "ACC_ID";
			PreparedStatement ps2 = conn.prepareStatement(sql2, a_key);
			ps2.setInt(1, cred);
			ps2.executeUpdate();
			ResultSet rs2 = ps2.getResultSet();
			
			while(rs2.next()) {
			a_ids.add(rs2.getInt(1));
			a_bal.add(rs2.getDouble(3));
			us[0] = rs2.getString(5);
			us[1] = rs2.getString(7);
			}

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Account retrieval completed...");
		System.out.println();
		System.out.println("Hello " + us[0] + ", username "  + us[1] + "\n"
				+ "Your banking information:\n\n");
		for(int count = 0; count <= (a_ids.size()-1); count++) {
			System.out.println("Account number: " + a_ids.get(count) + "\tBalance: " + a_bal.get(count) + "\n");
		}
		
		return a_ids;
	}
	
	@Override
	public Accounts makeTransac(Integer aid) {
		// TODO Auto-generated method stub
		Accounts acc = new Accounts();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM ACCOUNTS WHERE ACC_ID = (?)";
			PreparedStatement xk = conn.prepareStatement(sql);
			xk.setInt(1, aid);
			xk.executeQuery();
			ResultSet rs = xk.getResultSet();
			while(rs.next()) {
				
				acc.setAcctId(rs.getInt(1));
				acc.setuId(rs.getInt(2));
				acc.setBalance(rs.getDouble(3));
			}
			xk.closeOnCompletion();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//System.out.println(acc.toFile());

		return acc;
	}
	public void dOw(Integer accid, Double balance) {
		Scanner g = new Scanner(System.in);
		Accounts aaa = new Accounts();
		System.out.println("\nWould you like to make a DEPOSIT(1), make a WITHDRAWAL(2) or FINISH(3) transaction?");

				String g1 = g.nextLine();
				
				switch(g1) {
				case "1":
					deposit(accid, balance);
					aaa = makeTransac(accid);
					System.out.println("New Balance for Bank Account #" + aaa.getAcctId() + " is $" + aaa.getBalance());
					dOw(aaa.getAcctId(), aaa.getBalance());
					break;
				case "2":
					withdraw(accid, balance);
					aaa = makeTransac(accid);
					System.out.println("New Balance for Bank Account #" + aaa.getAcctId() + " is $" + aaa.getBalance());
					dOw(aaa.getAcctId(), aaa.getBalance());
					break;
				case "3":
					System.out.println("\nExiting Bank Account Transactions menu.");
				default:
					
					break;
				}
	}
	@Override
	public Accounts deposit(Integer aid, Double curBal) {
		// TODO Auto-generated method stub
		Accounts a = new Accounts();
		System.out.println("Please type an amount to deposit:");
		Double mon = negChk();
		Double newBal = curBal + mon;
		try(Connection con = ConnectionFactory.getInstance().getConnection()){

			con.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS SET BALANCE = (?) WHERE ACC_ID = (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, newBal);
			ps.setInt(2, aid);
			ps.executeUpdate();
//			System.out.println("New Balance is " + newBal + ".");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\nTransaction finished successfully.\n");
		return null;
	}

	@Override
	public Accounts withdraw(Integer aid, Double curBals) {
		// TODO Auto-generated method stub
		Accounts a = new Accounts();
		System.out.println("Current balance from withdraw is " + curBals);
		System.out.println("Please type an amount to withdraw:");
		Double mon = overDraw(curBals);
		Double newBal = curBals - mon;
		try(Connection con = ConnectionFactory.getInstance().getConnection()){

			con.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS SET BALANCE = (?) WHERE ACC_ID = (?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, newBal);
			ps.setInt(2, aid);
			ps.executeUpdate();
//			System.out.println("New Balance is " + newBal + ".");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\nTransaction finished successfully.\n");
		return null;
		
	}

	public Double overDraw(Double curB) {
		Scanner pwn = new Scanner(System.in);
		Double gucci = pwn.nextDouble();
		if(gucci <= curB) {
			return gucci;
		}
		System.out.println("Overdraws aren't cool.");
		return overDraw(curB);
	}
	
	public Double negChk() {
		Scanner ty = new Scanner(System.in);
		Double money = ty.nextDouble();
		if(money > 0) {
			return money;
		}
		System.out.println("Amount cannot be zero or negative!");
		return negChk();
	}
		

}
