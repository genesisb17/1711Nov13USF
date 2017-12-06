package com.rev.pojos;

public class Reimbursement {

	private int reimbID;
	private double amount;
	private double submitted;
	private double resolved;
	private String description;
	private String receipt;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimbursement() {}
	
	public Reimbursement(int reimbID, double amount, double submitted, double resolved, String description, String receipt,
			int author, int resolver, int statusID, int typeID) {
		super();
		this.reimbID = reimbID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}





	public int getReimbID() {
		return reimbID;
	}



	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
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
	
	
	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusID=" + statusID + ", typeID=" + typeID + "]";
	}

	
	
	
	
}
