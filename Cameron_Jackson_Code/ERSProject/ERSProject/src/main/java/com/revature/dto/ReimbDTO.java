package com.revature.dto;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public class ReimbDTO {
	private Reimbursement reimb;
	private Users author;
	private Users resolver;
	private String status;
	private String type;
	
	public ReimbDTO() {}

	public ReimbDTO(Reimbursement reimb, Users author, Users resolver, String status, String type) {
		super();
		this.reimb = reimb;
		this.author = author;
		this.resolver = resolver;
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

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public Users getResolver() {
		return resolver;
	}

	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}



}
