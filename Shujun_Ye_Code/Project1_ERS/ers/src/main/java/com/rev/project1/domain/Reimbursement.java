package com.rev.project1.domain;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 * Reimbursement POJO
 * @author Shujun Ye
 */
public class Reimbursement {
	
	/** Reimbursement id auto-generates by DB */
	private int reimbId;
	/** Reimbursement amount */
	private double reimbAmount;
	/** Reimbursement submitted date and time */
	private Timestamp reimbSubmitted;
	/** Reimbursement resolved date and time */
	private Timestamp reimbResolved;
	/** Reimbursement description */
	private String reimbDescription;
	/** Reimbursement receipt image */
	private Blob reimbReceipt;
	/** Reimbursement author who creates the reimbursement */
	private int reimbAuthor;
	/** Reimbursement resolver who authorizes the reimbursement */
	private int reimbResolver;
	/** Reimbursement status id */
	private int reimbStatusId;
	/** Reimbursement type id */
	private int reimbTypeId;
	
	/** Reimbursement constructor with no-arg */
	public Reimbursement() {}

	/**
	 * Reimbursement constructor with parameters
	 * @param reimbAmount reimbursement amount
	 * @param
	 * @param reimbAuthor reimbursement author
	 * @param reimbStatusId reimbursement status id
	 * @param reimbTypeId reimbursement type id
	 */
	public Reimbursement(double reimbAmount, String reimbDescription, int reimbAuthor, int reimbStatusId, int reimbTypeId) {
		super();
//		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}

	/**
	 * Return reimbursement id
	 * @return reimbursement id
	 */
	public int getReimbId() {
		return reimbId;
	}

	/**
	 * Set reimbursement id
	 * @param reimbId reimbursement id
	 */
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	/**
	 * Return reimbursement amount
	 * @return reimbursement amount
	 */
	public double getReimbAmount() {
		return reimbAmount;
	}

	/**
	 * Set reimbursement amount
	 * @param reimbAmount reimbursement amount
	 */
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	/**
	 * Return reimbursement submitted date and time
	 * @return reimbursement submitted date and time
	 */
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	/**
	 * Set reimbursement submitted date and time
	 * @param reimbSubmitted
	 */
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	/**
	 * Return reimbursement resolved date and time
	 * @return reimbursement resolved date and time
	 */
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	/**
	 * Set reimbursement resolved date and time
	 * @param reimbResolved reimbursement resolved date and time
	 */
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	/**
	 * Return reimbursement description
	 * @return reimbursement description
	 */
	public String getReimbDescription() {
		return reimbDescription;
	}

	/**
	 * Set reimbursement description
	 * @param reimbDescription reimbursement description
	 */
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	/**
	 * Return reimbursement receipt
	 * @return reimbursement receipt
	 */
	public Blob getReimbReceipt() {
		return reimbReceipt;
	}

	/**
	 * Set reimbursement receipt
	 * @param reimbReceipt reimbursement receipt
	 */
	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	/**
	 * Return reimbursement author
	 * @return reimbursement author
	 */
	public int getReimbAuthor() {
		return reimbAuthor;
	}

	/**
	 * Set reimbursement author
	 * @param reimbAuthor reimbursement author
	 */
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	/**
	 * Return reimbursement resolver
	 * @return reimbursement resolver
	 */
	public int getReimbResolver() {
		return reimbResolver;
	}

	/**
	 * Set reimbursement resolver
	 * @param reimbResolver reimbursement resolver
	 */
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	/**
	 * Return reimbursement status id
	 * @return reimbursement status id
	 */
	public int getReimbStatusId() {
		return reimbStatusId;
	}

	/**
	 * Set reimbursement status id
	 * @param reimbStatusId reimbursement status id
	 */
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	/**
	 * Return reimbursement type id
	 * @return reimbursement type id
	 */
	public int getReimbTypeId() {
		return reimbTypeId;
	}

	/**
	 * Set reimbursement type id
	 * @param reimbTypeId reimbursement type id
	 */
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	/**
	 * Return reimbursement's all info
	 */
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusId=" + reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}
}
