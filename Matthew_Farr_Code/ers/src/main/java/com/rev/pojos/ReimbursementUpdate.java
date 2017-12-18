package com.rev.pojos;

public class ReimbursementUpdate {

	private int reimbursementId;
	private int statusId;

	public ReimbursementUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementUpdate(int reimbursementId, int statusId) {
		super();
		this.reimbursementId = reimbursementId;
		this.statusId = statusId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "ReimbursementUpdate [reimbursementId=" + reimbursementId + ", statusId=" + statusId + "]";
	}

}
