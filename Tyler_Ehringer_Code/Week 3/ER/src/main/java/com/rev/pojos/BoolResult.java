package com.rev.pojos;

public class BoolResult {
	
	private boolean value;
	
	public BoolResult(){
		value = false;
	}
	
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public BoolResult(boolean val) {
		value = val;
	}
	

}
