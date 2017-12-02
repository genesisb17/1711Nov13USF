package com.revature.pojos;

import java.sql.Blob;

import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;

public class Reimbursement {
	private int reimbId;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private Blob receipt;
	private Users author;
	private Users resolver;
	private ReimbursementStatus status;
	private ReimbursementType type;
	
	public Reimbursement() {}

	public Reimbursement(int reimbId, double amount, String submitted, String resolved, String description,
			Blob receipt, Users author, Users resolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public Users getResolver() {
		return resolver;
	}

	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}
	
	public String getStatusStr() {
		switch (status) {
		case APPROVED:
			return "APPROVED";
		case DENIED:
			return "DENIED";
		case PENDING:
			return "PENDING";
		default:
			return null;
		}
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}
	
	public String getTypeStr() {
		switch (type) {
		case FOOD:
			return "FOOD";
		case LODGING:
			return "LODGING";
		case OTHER:
			return "OTHER";
		case TRAVEL:
			return "TRAVEL";
		default:
			return null;
		}
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
	
}
