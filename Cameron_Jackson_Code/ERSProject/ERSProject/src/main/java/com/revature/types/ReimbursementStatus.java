package com.revature.types;

public enum ReimbursementStatus {
	/* 
	 * Order of these is very important
	 * They correspond to the order in the database for easy conversions
	 * from status to string and vice versa
	 */
	PENDING, APPROVED, DENIED
}
