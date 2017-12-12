package com.rev.pojos;

public class R_Status {
	
	private int id;
	private String status;

	public R_Status() {}

	public R_Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "R_Status [id=" + id + ", status=" + status + "]";
	}
	
}
