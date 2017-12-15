package com.rev.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int reimb_id;
	private double amount;
	private Blob receipt;
	private String description;
	private int author;
	private int resolver;
	private int status_id;
	private int type_id;
	private Timestamp submitted;
	private Timestamp resolved;
	private String author_first_name;
	private String author_last_name;
	
	public Reimbursement() {}
	


	public Reimbursement(int reimb_id, double amount, Blob receipt, String description, int author, int resolver,
			int status_id, int type_id, Timestamp submitted, Timestamp resolved, String author_first_name,
			String author_last_name) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.receipt = receipt;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author_first_name = author_first_name;
		this.author_last_name = author_last_name;
	}



	public Reimbursement(int reimb_id, double amount, Blob receipt, String description, int author, int resolver,
			int status_id, int type_id, Timestamp submitted, Timestamp resolved) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.receipt = receipt;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
		this.submitted = submitted;
		this.resolved = resolved;
	}

	

	public int getAuthor() {
		return author;
	}



	public void setAuthor(int author) {
		this.author = author;
	}



	public String getAuthor_first_name() {
		return author_first_name;
	}



	public void setAuthor_first_name(String author_first_name) {
		this.author_first_name = author_first_name;
	}



	public String getAuthor_last_name() {
		return author_last_name;
	}



	public void setAuthor_last_name(String author_last_name) {
		this.author_last_name = author_last_name;
	}



	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}



	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", amount=" + amount + ", receipt=" + receipt + ", description="
				+ description + ", author=" + author + ", resolver=" + resolver + ", status_id=" + status_id
				+ ", type_id=" + type_id + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", author_first_name=" + author_first_name + ", author_last_name=" + author_last_name + "]";
	}


}


	





