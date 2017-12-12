package com.revature.types;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReimbursementStatus {
	/* 
	 * Order of these is very important
	 * They correspond to the order in the database for easy conversions
	 * from status to string and vice versa
	 */
	PENDING("PENDING", 1), 
	APPROVED("APPROVED", 2), 
	DENIED("DENIED", 3);
	
	private String name;
	private int value;
	
	ReimbursementStatus (String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
