package com.revature.pojos;

import java.sql.Blob;

public class Reimbursement {
	private Integer reimbId;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private Blob receipt;
	private Integer author;
	private Integer resolver;
	private Integer statusId;
	private Integer typeId;
	
	public Reimbursement() {}

	public Reimbursement(Integer reimbId, double amount, String submitted, String resolved, String description,
			Blob receipt, Integer author, Integer resolver, Integer statusId, Integer typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Integer getReimbId() {
		return reimbId;
	}

	public void setReimbId(Integer reimbId) {
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

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Integer getResolver() {
		return resolver;
	}

	public void setResolver(Integer resolver) {
		this.resolver = resolver;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
	
}
