package com.reimbursement.dao;

import java.util.ArrayList;

import com.reimbursement.pojos.Employee;
import com.reimbursement.pojos.Reimbursement;

public interface DAO {
	public ArrayList getAllUsers();
	public Employee getUserById(Integer uId);
	public ArrayList<Reimbursement> getAllReimbursements();
	public Reimbursement makeReimbursement(Integer amount, String desc, Integer empId, Integer reimbType);
	public Employee registerUser(String username, String password, String firstname, String lastname, String email, Integer role);
	public String getRoles(Integer RId);
	public Reimbursement updateReimbursement(Integer reiId, Integer reiStat, Integer resoId);
	public ArrayList<Reimbursement> getReById(Integer reimbursementId);
	public Boolean valEmail(String email);
}
