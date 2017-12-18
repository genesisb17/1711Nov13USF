package com.rev.dtos;

import com.rev.pojos.Reimbursement;

public class UserReimbursementDTO {
	
	private String submitted;
	private String amount;
	private String type;
	private String description;
	private String status;
	private String resolved;
	public UserReimbursementDTO() {
		super();
	}
	public UserReimbursementDTO(Reimbursement reimbursement) {
		super();
		
		this.submitted = reimbursement.getSubmitted().toString();
		this.amount = "$" + String.valueOf(reimbursement.getAmount());
		switch(reimbursement.getStatusID()){
		case 21:
			this.status = "Pending";
			break;
		case 22:
			this.status = "Approved";
			break;
		case 23:
			this.status = "Denied";
			break;
		default:
			this.type = "null";
			break;
		}
		if(reimbursement.getDescription() == null) {
			this.description = "No Description Given";
		}
		else {
			this.description = reimbursement.getDescription();
		}
		switch(reimbursement.getTypeID()) {
		case 21:
			this.type = "Lodging";
			break;
		case 22:
			this.type = "Travel";
			break;
		case 23:
			this.type = "Food";
			break;
		case 24:
			this.type = "Other";
			break;
		default:
			this.type = "null";
			break;
		}
		if (reimbursement.getResolved() == null) {
			this.resolved = "Not Yet Resolved";
		}
		else {
			this.resolved = reimbursement.getResolved().toString();
		}
	}
	public UserReimbursementDTO(String submitted, String amount, String type, String description, String status,
			String resolved) {
		super();
		this.submitted = submitted;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.status = status;
		this.resolved = resolved;
	}
	public String getSubmitted() {
		return submitted;
	}
	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	@Override
	public String toString() {
		return "UserReimbursementDTO [submitted=" + submitted + ", amount=" + amount + ", type=" + type
				+ ", description=" + description + ", status=" + status + ", resolved=" + resolved + "]";
	}
	
	
		

}
