package com.rev.service;
import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDao;
import com.rev.pojo.R;
import com.rev.pojo.User;

public class Service 
{
	static DAO dao = new FileDao();
	public int findmax()
	{
		return dao.findmax();
	}
	public int getRtypeById(String i)
	{
		return dao.getRtypeById(i);
	}
	public int getRStatusById(String i)
	{
		return dao.getRStatusById(i);
	}
	public int geters_user_rolesbyId(String role)
	{
		return dao.geters_user_rolesbyId(role);
	}
	public void UpdateStatus(int id)
	{
		dao.UpdateStatus(id);
	}
	public void UpdateReimb(int reimbid1, int uid2)
	{
		dao.UpdateReimb(reimbid1, uid2);
	}
	public void addReimbursements(double amount,  String Description, int uid,int statusid, int typeid, int uid2)
	{
		dao.addReimbursements(amount,Description, uid,statusid,typeid,uid2);
	}
	public void addRStatus(String s)
	{
		dao.addRStatus(s);
	}
	public void adders_users(String user, String pass, String first, String last, String email,int i)
	{
		dao.adders_users(user, pass, first, last, email,i);
	}
	public void addRtype(String s)
	{
		dao.addRtype(s);;
	}
	public void adders_user_roles(String s)
	{
		dao.adders_user_roles(s);
	}	
	public User geters_users(String user, String pass)
	{
		return dao.geters_users(user, pass);
	}
	public  ArrayList <R> getReimbursements(String username, String password) 
	{
		// TODO Auto-generated method stub
		ArrayList<R> a = new ArrayList<R>();
		a = dao.getReimbursements(username, password);
		return a ;
	}
	public String getRtype(int i) 
	{
		return dao.getRtype(i);
	}
	public String getRStatus(int i) 
	{
		return dao.getRStatus(i);
	}
	public String geters_user_roles(int i)
	{
		return dao.geters_user_roles(i);
	}
}