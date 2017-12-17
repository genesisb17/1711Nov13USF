package com.rev.pojos;

import java.sql.Timestamp;

public class ReimbursementNames {
	private int reimb_id;
	private double amount;
	private String description;
	private int author;
	private int resolver;
	private int status_id;
	private int type_id;
	private Timestamp submitted;
	private Timestamp resolved;
	private String first_name;
	private String last_name;
	
	public ReimbursementNames() {}
	
	public ReimbursementNames(int reimb_id, double amount, String description, int author, int resolver, int status_id,
			int type_id, Timestamp submitted, Timestamp resolved, String first_name, String last_name) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_id = status_id;
		this.type_id = type_id;
		this.submitted = submitted;
		this.resolved = resolved;
		this.first_name = first_name;
		this.last_name = last_name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "ReimbursementNames [reimb_id=" + reimb_id + ", amount=" + amount + ", description=" + description
				+ ", author=" + author + ", resolver=" + resolver + ", status_id=" + status_id + ", type_id=" + type_id
				+ ", submitted=" + submitted + ", resolved=" + resolved + ", first_name=" + first_name + ", last_name="
				+ last_name + "]";
	}
	
	
	
	
	
}



