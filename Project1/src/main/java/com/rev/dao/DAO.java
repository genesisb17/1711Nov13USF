package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.R;
public interface DAO 
{
	
	R getReimbursements(String username,String password);

	void addRtype(String s);
	void addRStatus(String s);
	void adders_users(String user, String pass, String first, String last, String email);
	void adders_user_roles(String s);

	String getRtype(int i);
	String getRStatus(int i);
	int geters_users(String user,String pass);
	String geters_user_roles(int i);

}