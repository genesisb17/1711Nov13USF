package com.revature.ers.pojos;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimbursementId;
	private double amount;
	private Timestamp timeResolved;
	private String description;
	private byte[] receipt;
	private int authorId;				//references a User.userId
	private int resolverId;				//references a User.userId
	private int statusId;				//references a ReimbursementStatus.statusId
	private int typeId;					//references a ReimbursementType.typeId
	
	/*
	 * No args constructor
	 */
	public Reimbursement() {
		super();
	}
	
	/**
	 * @param reimbursementId
	 * @param amount
	 * @param timeResolved
	 * @param description
	 * @param receipt
	 * @param authorId
	 * @param resolverId
	 * @param statusId
	 * @param typeId
	 */
	public Reimbursement(int reimbursementId, double amount, Timestamp timeResolved, String description, byte[] receipt,
			int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.timeResolved = timeResolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	/**
	 * @return the reimbursementId
	 */
	public int getReimbursementId() {
		return reimbursementId;
	}

	/**
	 * @param reimbursementId the reimbursementId to set
	 */
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the timeResolved
	 */
	public Timestamp getTimeResolved() {
		return timeResolved;
	}

	/**
	 * @param timeResolved the timeResolved to set
	 */
	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the receipt
	 */
	public byte[] getReceipt() {
		return receipt;
	}

	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the resolverId
	 */
	public int getResolverId() {
		return resolverId;
	}

	/**
	 * @param resolverId the resolverId to set
	 */
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	@Override
	public String toString() {
		return "+----------------------------------+" +
			   "\nReimbursement Id: " + this.reimbursementId +
			   "\nAmount: " + this.amount +
			   "\nTime resolved: " + this.timeResolved + 
			   "\nDescription: " + this.description +
			   "\nReceipt: " + this.receipt +
			   "\nAuthor Id: " + this.authorId +
			   "\nResolver Id: " + this.resolverId +
			   "\nStatus:" + this.statusId +
			   "\nType: " + this.typeId +
			   "\n+----------------------------------+";
	}
}
