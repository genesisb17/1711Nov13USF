package com.rev.pojos;

import java.sql.Timestamp;

public class SpecTicket {
	int ticket_id;
	String firstName;
	String lastName;
	String email;
	double amount;
	Timestamp submitted;
	Timestamp resolved;
	String description;
	String resolver;
	String status;
	String type;

	public SpecTicket() {
	}

	public SpecTicket(int ticket_id, String firstName, String lastName, String email, double amount,
			Timestamp submitted, Timestamp resolved, String description, String resolver, String status, String type) {
		super();
		this.ticket_id = ticket_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
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

	@Override
	public String toString() {
		return "SpecTicket [ticket_id=" + ticket_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", resolver=" + resolver + ", status=" + status + ", type=" + type
				+ "]";
	}
	
}
