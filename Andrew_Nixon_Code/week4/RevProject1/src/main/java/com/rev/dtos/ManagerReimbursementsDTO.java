package com.rev.dtos;

import java.sql.Timestamp;

import com.rev.pojos.Reimbursement;

public class ManagerReimbursementsDTO {
	private String reimbursementID;
	private String submitted;
	private String amount;
	private String type;
	private String description;
	private String status;
	private String resolved;
	private String authorName;
	public ManagerReimbursementsDTO() {
		super();
	}
	public ManagerReimbursementsDTO( Reimbursement reimbursement) {
		super();
		this.reimbursementID = String.valueOf(reimbursement.getReimbID());
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
		this.authorName = authorName;
	}
	public ManagerReimbursementsDTO(String reimbursementID, String submitted, String amount, String type,
			String description, String status, String resolved, String authorName) {
		super();
		this.reimbursementID = reimbursementID;
		this.submitted = submitted;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.status = status;
		this.resolved = resolved;
		this.authorName = authorName;
	}
	public String getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(String reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = String.valueOf(reimbursementID);	}
	public String getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted.toString();
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
	public void setAmount(double amount) {
		this.amount = "$" + String.valueOf(amount);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setType(int type) {
		switch(type) {
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
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if(description == null) {
			this.description = "No Description Given";
		}
		else {
			this.description = description;
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStatus(int status) {
		switch(status){
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
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public void setResolved(Timestamp resolved) {
		if (resolved == null) {
			this.resolved = "Not Yet Resolved";
		}
		else {
			this.resolved = resolved.toString();
		}			
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "ManagerReimbursementsDTO [reimbursementID=" + reimbursementID + ", submitted=" + submitted + ", amount="
				+ amount + ", type=" + type + ", description=" + description + ", status=" + status + ", resolved="
				+ resolved + ", authorName=" + authorName + "]";
	}
}
