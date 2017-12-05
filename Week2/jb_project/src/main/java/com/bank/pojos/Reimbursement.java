package com.bank.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {

	private Integer reimbId;
	private Integer reimbAmount;
	private Timestamp reimbSubmitted; 
	private Timestamp reimbResolved;
	private String reimbDescription;
	private Blob reimbReceipt;
	private Integer reimbAuthor;
	private Integer reimbResolver;
	private Integer reimbStatId;
	private Integer reimbTypeId;

	public Reimbursement() {
		
	}
	
	public Reimbursement(Integer reimbId, Integer reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Blob reimbReceipt, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatId,
			Integer reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatId = reimbStatId;
		this.reimbTypeId = reimbTypeId;
	}

	public Integer getReimbId() {
		return reimbId;
	}

	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}

	public Integer getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(Integer reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Blob getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public Integer getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(Integer reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public Integer getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(Integer reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public Integer getReimbStatId() {
		return reimbStatId;
	}

	public void setReimbStatId(Integer reimbStatId) {
		this.reimbStatId = reimbStatId;
	}

	public Integer getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(Integer reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	
	
}
