package com.rev.pojos;

public class ReimbursementSubmission {

	private double amount;
	private String description;
	private int typeId;

	public ReimbursementSubmission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementSubmission(double amount, String description, int typeId) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
	}
	
	@Override
	public String toString() {
		return "ReimbursementSubmission [amount=" + amount + ", description=" + description + ", typeId=" + typeId
				+ "]";
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
