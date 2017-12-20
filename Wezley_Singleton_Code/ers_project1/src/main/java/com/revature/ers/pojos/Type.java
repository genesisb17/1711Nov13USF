package com.revature.ers.pojos;

public enum Type {
	
	LODGING, TRAVEL, FOOD, OTHER;
	
	@Override
	public String toString() {
		
		switch(this) {
		
			case LODGING:	return "lodging";
			case TRAVEL:	return "travel";
			case FOOD:		return "food";
			case OTHER:		return "other";
			default:		return "";
			
		}
	}
}