package com.revature.dto;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public class ReimbDTO {
	private Reimbursement reimb;
	private Users user;
	private String status;
	private String type;
	
	public ReimbDTO() {}

	public ReimbDTO(Reimbursement reimb, Users user, String status, String type) {
		super();
		this.reimb = reimb;
		this.user = user;
		this.status = status;
		this.type = type;
	}

	public Reimbursement getReimb() {
		return reimb;
	}

	public void setReimb(Reimbursement reimb) {
		this.reimb = reimb;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ReimbDTO [reimb=" + reimb + ", user=" + user + ", status=" + status + ", type=" + type + "]";
	}
}
