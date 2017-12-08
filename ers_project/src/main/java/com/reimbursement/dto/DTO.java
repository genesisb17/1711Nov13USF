package com.reimbursement.dto;

import java.util.ArrayList;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.Employee;

public class DTO {
	private Employee employee;
	private ArrayList<Reimbursement> reimbursements;
	
	public DTO() {}
	
	public DTO(Employee employee, ArrayList<Reimbursement> reimbursements) {
		this.setEmployee(employee);
		this.reimbursements = reimbursements;
	}

	public ArrayList<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(ArrayList<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}