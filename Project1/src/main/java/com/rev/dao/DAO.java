package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.R;
public interface DAO 
{
	void addRtype(String s);
	R getReimbursements(String username,String password);
	void addRStatus(String s);
	void adders_users(String user, String pass, String first, String last, String email);
	void adders_user_roles(String s);
}
