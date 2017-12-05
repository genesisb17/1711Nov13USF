package com.bank.dao;
import java.util.ArrayList;

import com.bank.pojos.Accounts;
import com.bank.pojos.Employee;
import com.bank.pojos.Reimbursement;
import com.bank.pojos.Users;

public interface DAO {
//	
//	public Users addUser(ArrayList<String> input);
//	public Accounts addAccount(Integer uid);
//	public Users logOn(String un, String pwd);
//	public ArrayList<Integer> acctDetails(Integer cred);
//	public Accounts makeTransac(Integer aid);
//	public Accounts deposit(Integer aid, Double curBal);
//	public Accounts withdraw(Integer aid, Double curBal);
//	public void dOw(Integer accid, Double balance);
//	
	public ArrayList getAllUsers();
	public Reimbursement getAllReimbursements(Integer empId);
	public Employee registerUser(ArrayList<Employee> input);
}