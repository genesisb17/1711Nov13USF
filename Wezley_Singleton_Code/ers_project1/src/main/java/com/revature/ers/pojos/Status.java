package com.revature.ers.pojos;

public enum Status {

	APPROVED, DENIED, PENDING;

	@Override
	public String toString() {
		switch(this) {

			case APPROVED:	return "approved";
			case DENIED:	return "denied";
			case PENDING:	return "pending";
			default:		return "";

		}
	}
}