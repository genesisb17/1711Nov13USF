package com.revature.ers.dto;

import java.sql.Timestamp;
import java.util.Arrays;

public class DetailedReimbursement {
	
	private int reimbursementId;
	private double amount;
	private Timestamp timeResolved;
	private String description;
	private byte[] receipt;
	private String author;
	private String resolver;
	private String status;
	private String type;
	
	public DetailedReimbursement() { }
	
	public DetailedReimbursement(int reimbursementId, double amount, Timestamp timeResolved, String description,
			byte[] receipt, String author, String resolver, String status, String type) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.timeResolved = timeResolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
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

	@Override
	public String toString() {
		return "DetailedReimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", timeResolved="
				+ timeResolved + ", description=" + description + ", receipt=" + Arrays.toString(receipt) + ", author="
				+ author + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
	
	
	
	

}
