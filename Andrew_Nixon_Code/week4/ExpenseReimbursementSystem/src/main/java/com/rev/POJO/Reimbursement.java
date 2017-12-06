package com.rev.POJO;

public class Reimbursement {

	private int rID;
	private double amount;
	private double submitted;
	private double resolved;
	private String description;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimbursement() {}
	
	public Reimbursement(int rID, double amount, double submitted, double resolved,
			String description, int author,	int resolver, int statusID, int typeID) {
		super();
		this.rID = rID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}



	public int getrID() {
		return rID;
	}



	public void setrID(int rID) {
		this.rID = rID;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public double getSubmitted() {
		return submitted;
	}



	public void setSubmitted(double submitted) {
		this.submitted = submitted;
	}



	public double getResolved() {
		return resolved;
	}



	public void setResolved(double resolved) {
		this.resolved = resolved;
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



	public int getStatusID() {
		return statusID;
	}



	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}



	public int getTypeID() {
		return typeID;
	}



	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}



	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", statusID=" + statusID + ", typeID=" + typeID + "]";
	}
	
	
	
}
