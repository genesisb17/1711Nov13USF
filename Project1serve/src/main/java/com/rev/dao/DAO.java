package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.R;
import com.rev.pojo.User;
public interface DAO 
{
	void addRtype(String s);
	void addRStatus(String s);
	void adders_users(String user, String pass, String first, String last, String email,int i);
	void adders_user_roles(String s);
	void addReimbursements(double amount,String Description,int uid,int statusid,int typeid,int userroleid);

	ArrayList<R> getReimbursements(String username,String password);
	String getRtype(int i);
	String getRStatus(int i);
	User geters_users(String user,String pass);
	String geters_user_roles(int i);
	
	
	int geters_user_rolesbyId(String role);
	int getRStatusById(String i);
	int getRtypeById(String i);
	void UpdateStatus(int id);
	void UpdateReimb(int reimbid1,int uid2);
	int findmax();
	int findmax1();
}