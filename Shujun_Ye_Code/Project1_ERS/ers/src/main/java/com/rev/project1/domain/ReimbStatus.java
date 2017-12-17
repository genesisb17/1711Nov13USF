package com.rev.project1.domain;

/**
 * Reimbursement statuses
 * @author Shujun Ye
 */
public enum ReimbStatus {
	PENDING(100),
	APPROVED(200),
	DENIED(300)
	;
	
	/** Status id associated with different reimbursement statuses */
	private final int statusId;
	
	/**
	 * ReimbStatus constructor
	 * @param statusId reimbursement status id
	 */
	ReimbStatus(int statusId){
		this.statusId = statusId;
	}
	
	/**
	 * Return reimbursement status id
	 * @return status id
	 */
	public int getStatusId() {
		return statusId;
	}
}
