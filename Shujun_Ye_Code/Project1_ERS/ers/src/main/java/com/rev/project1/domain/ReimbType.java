package com.rev.project1.domain;

/**
 * Different types of reimbursement
 * @author Shujun Ye
 */
public enum ReimbType {
	LODGING(1001),
	TRAVEL(1002),
	FOOD(1003),
	OTHER(1004)
	;
	
	/** Type id associated with different types of reimbursement */
	private final int typeId;
	
	/**
	 * ReimbType constructor
	 * @param typeId reimbursement type id
	 */
	ReimbType(int typeId){
		this.typeId = typeId;
	}
	
	/**
	 * Return reimbursement type id
	 * @return type id
	 */
	public int getTypeId() {
		return typeId;
	}
}
