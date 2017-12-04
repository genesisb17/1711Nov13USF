package com.revature.ers.pojos;

public enum Type {
	
	BUSINESS, TRAVEL, MEDICAL;
	
	@Override
	public String toString() {
		
		switch(this) {
		
			case BUSINESS:	return "business";
			case TRAVEL:	return "travel";
			case MEDICAL:	return "medical";
			default:		return "";
			
		}
	}
}