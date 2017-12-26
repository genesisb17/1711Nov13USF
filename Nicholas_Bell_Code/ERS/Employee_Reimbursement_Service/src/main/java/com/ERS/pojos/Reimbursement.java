package com.ERS.pojos;

import java.sql.Date;

import oracle.sql.TIMESTAMP;

public class Reimbursement {
	int reimbursment_id;
	double amount;
	String description;
	boolean resolved;
	String resolvedD;
	String submittedD;
	Integer resolver;
	int type;
	int status;

	
	
	public Reimbursement() {};
	public Reimbursement(int reimbursment_id, 
			double amount,
			String description, 
			String resolvedD,
			String submittedD,
			Integer resolver,
			int type, 
			int status) {
		super();
		this.reimbursment_id = reimbursment_id;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.status = status;
		this.resolvedD = resolvedD;
		this.submittedD = submittedD;
	}
	public Reimbursement(Reimbursement r) {
		this.reimbursment_id = r.reimbursment_id;
		this.amount = r.amount;
		this.description = r.description;
		this.resolved = r.resolved;
		this.type = r.type;
		this.status = r.status;
		this.resolver = r.resolver;
		this.submittedD = r.submittedD;
	}
	
	public Reimbursement(double a, int t, String d) {
		this.amount = a;
		this.type = t;
		this.description = d;
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
	public String getSubmitted() {
		return submittedD;
	}
	public void setSubmitted(String date) {
		this.submittedD = date;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(Integer resolver) {
		this.resolver = resolver;
	}
	public int getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResolvedD() {
		return resolvedD;
	}
	public void setResolvedD(String resolvedD) {
		this.resolvedD = resolvedD;
	}
	public String getSubmittedD() {
		return submittedD;
	}
	public void setSubmittedD(String submittedD) {
		this.submittedD = submittedD;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursment_id=" + reimbursment_id + ", amount=" + amount + ", description="
				+ description + ", resolved=" + resolved + ", resolvedD=" + resolvedD + ", submittedD=" + submittedD
				+ ", resolver=" + resolver + ", type=" + type + ", status=" + status + "]";
	}
	
	

}
