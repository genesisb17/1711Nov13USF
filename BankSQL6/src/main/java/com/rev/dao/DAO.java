package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.Account;
import com.rev.pojo.newUser;

public interface DAO 
{
	void addUser(newUser u,int j);
	newUser getUser(String username,String pass,int j);
	void change(String username, double o,int j);
	void change1(String old, String n,int j);
	void delete(String u,String p);
	void addAccount(newUser u,double balance,int user_id);
	ArrayList<Account> getAccount(newUser u);
	void getArtbyid(newUser u);
}
