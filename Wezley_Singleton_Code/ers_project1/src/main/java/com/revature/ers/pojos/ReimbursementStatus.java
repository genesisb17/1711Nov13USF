package com.revature.ers.pojos;

public class ReimbursementStatus {

	private int statusId;
	private Status status;
	
	/*
	 * No args constructor
	 */
	public ReimbursementStatus() {
		super();
	}
	
	/**
	 * @param statusId
	 * @param status
	 */
	public ReimbursementStatus(int statusId, Status status) {
		super();
		this.statusId = statusId;
		this.status = status;
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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
}
