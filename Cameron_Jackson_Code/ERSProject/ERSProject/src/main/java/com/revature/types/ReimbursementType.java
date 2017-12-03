package com.revature.types;

public enum ReimbursementType {
	/* 
	 * Order of these is very important
	 * They correspond to the order in the database for easy conversions
	 * from type to string and vice versa
	 */
	LODGING, TRAVEL, FOOD, OTHER
}
