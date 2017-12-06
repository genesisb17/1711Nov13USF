package com.rev.DAO;

import java.util.ArrayList;

import com.rev.POJO.ERSUser;
import com.rev.POJO.Reimbursement;
import com.rev.POJO.ReimbursementStatus;
import com.rev.POJO.ReimbursementType;
import com.rev.POJO.UserRole;

public interface DAO {
	
	public ERSUser getUserByID(int userID);
	public ArrayList<ERSUser> getUsers();
	public Reimbursement getReimbursementByID(int rID);
	public ArrayList<Reimbursement> getReimbursements();
	public ReimbursementStatus getStatusByID(int statusID);
	public ReimbursementType getTypeByID(int typeID);
	public UserRole getRoleByID(int roleID);
	public ERSUser addUser(ERSUser ersUser);
	public Reimbursement addReimbursement(Reimbursement reimbursement);
	public ReimbursementStatus addStatus(ReimbursementStatus reimbursementStatus);
	public ReimbursementType addType(ReimbursementType reimbursementType);
	public UserRole addRole(UserRole userRole);
	public ERSUser getERSUserByUsername(String username);
	public ERSUser getERSUserByUsernameAndPassword(String username, String password);

}
