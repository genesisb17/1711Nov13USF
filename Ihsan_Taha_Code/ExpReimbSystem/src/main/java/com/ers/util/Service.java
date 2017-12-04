package com.ers.util;

import java.util.ArrayList;

import com.ers.dao.ReimbDAO;
import com.ers.dao.ReimbDAOImp;
import com.ers.dao.UserDAO;
import com.ers.dao.UserDAOImp;
import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;

public class Service
{
	// ------------------------------------------------------------
	// UserDAO Service
	// ------------------------------------------------------------
	public UserDAO userDao = new UserDAOImp();
	public ReimbDAO ReimbDao = new ReimbDAOImp();

	public ArrayList<User> getAllUsers()
	{
		return userDao.getAllUsers();
	}

	public User addUser(User user)
	{
		return userDao.addUser(user);
	}

	public User getUser(User user)
	{
		return userDao.getUser(user);
	}

	public void deleteUser(int user_id)
	{
		userDao.deleteUser(user_id);
	}

	// ------------------------------------------------------------
	// ReimbDAO Service
	// ------------------------------------------------------------
	public ArrayList<Reimbursement> getAllReimb(User user)
	{
		return ReimbDao.getReimbById(user);
	}

	public ArrayList<Reimbursement> getReimbById(User user)
	{
		return ReimbDao.getReimbById(user);
	}

	public Reimbursement addReimb(User user, Reimbursement reimb)
	{
		return ReimbDao.addReimb(user, reimb);
	}

	public Reimbursement getReimb(int reimb_id)
	{
		return ReimbDao.getReimb(reimb_id);
	}

	public void updateReimb(Reimbursement reimb)
	{
		ReimbDao.updateReimb(reimb);
	}
	
	public void deleteReimb(int reimb_id)
	{
		ReimbDao.deleteReimb(reimb_id);
	}
}
