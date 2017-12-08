package com.reimbursement.services;

import java.util.ArrayList;

import com.reimbursement.dao.DAO;
import com.reimbursement.dao.DAOimpl;

import com.reimbursement.pojos.Employee;
import com.reimbursement.pojos.Reimbursement;

public class Services {
	static DAO dao = new DAOimpl();		
	
	public ArrayList<Reimbursement> getRById(Integer empId) {
	ArrayList<Reimbursement> tw = new ArrayList<>();
	return dao.getReById(empId);
	}
	public void getAllUsers() {
	
		ArrayList<Employee> x = new ArrayList<>();
		x = dao.getAllUsers();

		for(Employee get : x) {
			System.out.println(get.toString());
		}
		
	}

	public Employee validateUser(String username) {
		ArrayList<Employee> x = new ArrayList<>();

		x = dao.getAllUsers();
		for(Employee get : x) {
			
			if(get.getUserName().equals(username)) {
				System.out.println("Match");

				return get;
			}

		}
		
		return null;
	}

	public Employee addUser(Employee e) {
		
		return dao.registerUser(e.getUserName(), e.getPassword(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getUserRoleId());
	}

	public Boolean valEmail(String email) {
		
		return dao.valEmail(email);
	}
	public Reimbursement makeReimb(Reimbursement r) {
		r = dao.makeReimbursement(r.getReimbAmount(), r.getReimbDescription(), r.getReimbAuthor(), r.getReimbTypeId());
		return r;
	}
	public ArrayList<Reimbursement> getAllR() {

		return dao.getAllReimbursements();
	
	}
	
//	public Reimbursement makeReimb(Integer amt, String des, Integer id, Integer type) {
//		System.out.println("In services " +amt + " "+ des + " "+ id + " "+ type);
//		return dao.makeReimbursement(amt, des, id, type);
//		
//	}
	
	public Reimbursement updateReimb(Reimbursement r) {
		return dao.updateReimbursement(r.getReimbId(), r.getReimbStatId(), r.getReimbResolver());
	}
}

