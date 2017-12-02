package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;

public class ERSDatabaseDAO implements ERSDAO {

	@Override
	public Users getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users addUser(Users newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getPastTickets(Users employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getTicket(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllTickets(Users manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement addTicket(Reimbursement newTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement resolveTicket(int reimbId, ReimbursementStatus status, int resolverId) {
		// TODO Auto-generated method stub
		return null;
	}

}
