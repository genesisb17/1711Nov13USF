package com.rev.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
	public int reimbID;
	public int reimbAmount;
	public Timestamp reimbSubmitted;
	public Timestamp reimbResolved;
	public String reimbDescription;
	public Blob reimbReceipt;
	public int reimbAuthor;
	public int reimbResolver;
	public int reimbStatusID;
	public int reimbTypeID;
	
	public Reimbursement(){
		
		reimbID = 0;
		reimbAmount = 0;
		reimbSubmitted = null;
		reimbResolved = null;
		reimbDescription = null;
		reimbReceipt = null;
		reimbAuthor = 0;
		reimbResolver = 0;
		reimbStatusID = 0;
		reimbTypeID = 0;
		
	}
	
	public Timestamp getReimbSubmitted()
	{
		return reimbSubmitted;
	}
	
	public void setReimbSubmitted(Timestamp timestamp) {
		this.reimbSubmitted = timestamp;
		
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public int getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp timestamp) {
		this.reimbResolved = timestamp;
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

	public void setReimbReceipt(Blob blob) {
		this.reimbReceipt = blob;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatusID() {
		return reimbStatusID;
	}

	public void setReimbStatusID(int statusID) {
		this.reimbStatusID = statusID;
	}

	public int getReimbTypeID() {
		return reimbTypeID;
	}

	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}

}
