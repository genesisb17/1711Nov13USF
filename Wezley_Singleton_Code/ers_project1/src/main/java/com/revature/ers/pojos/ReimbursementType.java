package com.revature.ers.pojos;

public class ReimbursementType {
	
	private int typeId;
	private Type type;
	
	/**
	 * No args constructor
	 */
	public ReimbursementType() {
		super();
	}
	
	/**
	 * @param typeId
	 * @param type
	 */
	public ReimbursementType(int typeId, Type type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}

	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
}