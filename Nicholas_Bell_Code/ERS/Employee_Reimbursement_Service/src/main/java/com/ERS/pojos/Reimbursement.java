package com.ERS.pojos;

import java.sql.Date;

public class Reimbursement {
	int reimbursment_id;
	double amount;
	String description;
	boolean resolved;
	
	//replace with date object
	Date submitted;
	int resolver;
	
	Enum<REIMBURSEMENT_TYPE> type;
	Enum<REIMBURSEMENT_STATUS> status;
	//receipt
	
	
	
	public Reimbursement(int reimbursment_id, 
			double amount, 
			boolean resolved, 
			String description,
			Enum<REIMBURSEMENT_TYPE> type, 
			Enum<REIMBURSEMENT_STATUS> status) {
		super();
		this.reimbursment_id = reimbursment_id;
		this.amount = amount;
		this.description = description;
		this.resolved = resolved;
		this.type = type;
		this.status = status;
	}
	public Reimbursement(Reimbursement r) {
		this.reimbursment_id = r.reimbursment_id;
		this.amount = r.amount;
		this.description = r.description;
		this.resolved = r.resolved;
		this.type = r.type;
		this.status = r.status;
		this.resolver = r.resolver;
		this.submitted = r.submitted;
	}
	
	public int getReimbursment_id() {
		return reimbursment_id;
	}
	public void setReimbursment_id(int reimbursment_id) {
		this.reimbursment_id = reimbursment_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date date) {
		this.submitted = date;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public Enum<REIMBURSEMENT_TYPE> getType() {
		return type;
	}
	public void setType(Enum<REIMBURSEMENT_TYPE> type) {
		this.type = type;
	}
	public Enum<REIMBURSEMENT_STATUS> getStatus() {
		return status;
	}
	public void setStatus(Enum<REIMBURSEMENT_STATUS> status) {
		this.status = status;
	}
	
	
	//receipt

}
