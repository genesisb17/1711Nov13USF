package com.rev.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reimbursement {
	
	private int reimbursementId;
	private double amount;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp submitted;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp resolved;
	private String description;
	private Blob receipt;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	// No argument constructor
	public Reimbursement() {
		super();
	}

	// All fields constructor
	public Reimbursement(int reimbursementId, double amount, Timestamp submitted, Timestamp resolved,
			String description, Blob receipt, int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + ", receipt=" + receipt + ", authorId="
				+ authorId + ", resolverId=" + resolverId + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
	
	
	/* * * * * * * * * * * * * * * * * *
	 * GETTERS AND SETTERS START HERE  *
	 * * * * * * * * * * * * * * * * * */
	
	public int getReimbursementId() {return reimbursementId;}

	public void setReimbursementId(int reimbursementId) {this.reimbursementId = reimbursementId;}

	public double getAmount() {return amount;}

	public void setAmount(double amount) {this.amount = amount;}

	public Timestamp getSubmitted() {return submitted;}

	public void setSubmitted(Timestamp submitted) {this.submitted = submitted;}

	public Timestamp getResolved() {return resolved;}

	public void setResolved(Timestamp resolved) {this.resolved = resolved;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

	public Blob getReceipt() {return receipt;}

	public void setReceipt(Blob receipt) {this.receipt = receipt;}

	public int getAuthorId() {return authorId;}

	public void setAuthorId(int authorId) {this.authorId = authorId;}

	public int getResolverId() {return resolverId;}

	public void setResolverId(int resolverId) {this.resolverId = resolverId;}

	public int getStatusId() {return statusId;}

	public void setStatusId(int statusId) {this.statusId = statusId;}

	public int getTypeId() {return typeId;}

	public void setTypeId(int typeId) {this.typeId = typeId;}
	
}
