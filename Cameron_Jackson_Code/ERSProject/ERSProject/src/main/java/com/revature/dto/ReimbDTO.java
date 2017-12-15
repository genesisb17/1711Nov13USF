package com.revature.dto;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public class ReimbDTO {
	private Integer reimbId;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private String author;
	private String resolver;
	private String status;
	private String type;
	
	public ReimbDTO() {}

	public ReimbDTO(Integer reimbId, double amount, String submitted, String resolved, String description,
			String author, String resolver, String status, String type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	@Override
	public String toString() {
		return "ReimbDTO [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}

}
