package com.rev.pojos;

public class R_Type {

	private int r_id;
	private String r_type;
	
	
	public R_Type() {}
	
	public R_Type(int r_id, String r_type) {
		super();
		this.r_id = r_id;
		this.r_type = r_type;
	}
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	@Override
	public String toString() {
		return "RTypes [r_id=" + r_id + ", r_type=" + r_type + "]";
	}
}
