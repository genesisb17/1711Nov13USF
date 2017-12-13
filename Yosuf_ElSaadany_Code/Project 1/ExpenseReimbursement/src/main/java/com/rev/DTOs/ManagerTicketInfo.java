package com.rev.DTOs;

public class ManagerTicketInfo {
	
	private int reimb_id;
	private String firstname;
	private String lastname;
	private String email;
	private double amount;
	private String resolverfn;
	private String resolverln;
	private int status;
	private int type;
	private String description;
	private String submitted;
	private String resolved;
	
	public ManagerTicketInfo() {}

	public ManagerTicketInfo(int reimb_id, String firstname, String lastname, String email, double amount,
			String resolverfn, String resolverln, int status, int type, String description, String submitted,
			String resolved) {
		super();
		this.reimb_id = reimb_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.amount = amount;
		this.resolverfn = resolverfn;
		this.resolverln = resolverln;
		this.status = status;
		this.type = type;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getResolverfn() {
		return resolverfn;
	}

	public void setResolverfn(String resolverfn) {
		this.resolverfn = resolverfn;
	}

	public String getResolverln() {
		return resolverln;
	}

	public void setResolverln(String resolverln) {
		this.resolverln = resolverln;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	@Override
	public String toString() {
		return "ManagerTicketInfo [reimb_id=" + reimb_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", amount=" + amount + ", resolverfn=" + resolverfn + ", resolverln="
				+ resolverln + ", status=" + status + ", type=" + type + ", description=" + description + ", submitted="
				+ submitted + ", resolved=" + resolved + "]";
	}

}
