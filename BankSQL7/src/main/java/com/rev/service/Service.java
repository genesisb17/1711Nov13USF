package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDao;
import com.rev.pojo.Account;
import com.rev.pojo.newUser;

public class Service 
{
	static DAO dao = new FileDao();
	public newUser addUser(newUser u,int j)
	{
		dao.addUser(u,j);
		return u;
	}
	public static newUser getUser(String username, String pass,int id)
	{
		return dao.getUser(username,pass,id);
	}
	public void change(String username,double o,int j) 
	{
		dao.change(username, o,j);
	}
	public void change1(String old,String n,int j) 
	{
		dao.change1(old, n,j);
	}
	public void delete(String u, String p) 
	{
		dao.delete(u, p);
	}
	
	public void createAccount(newUser u,double b,int ui) 
	{
		// TODO Auto-generated method stub
		dao.addAccount(u,b,ui);
		
	}
	
	public newUser validateUser(String user,String pass,int i){
		newUser user1 = dao.getUser(user,pass,65);
		if(user1.getId()==0) return null;
		return user1;
	}
	public void getArtbyid(newUser u)
	{
		dao.getArtbyid(u);
	}
	public  ArrayList<Account> getAccount(newUser u)
	{
		return dao.getAccount(u);
	}
	}