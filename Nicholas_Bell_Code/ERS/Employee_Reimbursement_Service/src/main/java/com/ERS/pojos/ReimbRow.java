package com.ERS.pojos;

public class ReimbRow {
	int id;
	String Sub_name;
	double amount;
	String type;
	String description;
	String submittedD;
	String status;
	String resolvedD;
	String resolver;
	
	public ReimbRow() {}
	
	public ReimbRow(int reimb_id, String sub_name, double amount, String type, String description, String submittedD,
			String status, String resolvedD, String resolver) {
		super();
		this.id = reimb_id;
		Sub_name = sub_name;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.submittedD = submittedD;
		this.status = status;
		this.resolvedD = resolvedD;
		this.resolver = resolver;
	}
	public int getReimb_id() {
		return id;
	}
	public void setReimb_id(int reimb_id) {
		this.id = reimb_id;
	}
	public String getSub_name() {
		return Sub_name;
	}
	public void setSub_name(String sub_name) {
		Sub_name = sub_name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
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
	public String getSubmittedD() {
		return submittedD;
	}
	public void setSubmittedD(String submittedD) {
		this.submittedD = submittedD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResolvedD() {
		return resolvedD;
	}
	public void setResolvedD(String resolvedD) {
		this.resolvedD = resolvedD;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	@Override
	public String toString() {
		return "ReimbRow [reimb_id=" + id + ", Sub_name=" + Sub_name + ", amount=" + amount + ", type=" + type
				+ ", description=" + description + ", submittedD=" + submittedD + ", status=" + status + ", resolvedD="
				+ resolvedD + ", resolver=" + resolver + "]";
	}
	
	

}
