package com.rev.pojos;

import java.sql.Timestamp;

public class Ticket {
	int ticket_ID;
	double amount;
	Timestamp submitted;
	Timestamp resolved;
	String description;
	int author_ID;
	int resolver_ID;
	int status_ID;
	int type_ID;

	public Ticket() {
		super();
	}

	public Ticket(int ticket_ID, int amount, Timestamp submitted, Timestamp resolved, String description, int author_ID,
			int resolver_ID, int status_ID, int type_ID) {
		super();
		this.ticket_ID = ticket_ID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author_ID = author_ID;
		this.resolver_ID = resolver_ID;
		this.status_ID = status_ID;
		this.type_ID = type_ID;
	}

	public int getTicket_ID() {
		return ticket_ID;
	}

	public void setTicket_ID(int ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	public int getAuthor_ID() {
		return author_ID;
	}

	public void setAuthor_ID(int author_ID) {
		this.author_ID = author_ID;
	}

	public int getResolver_ID() {
		return resolver_ID;
	}

	public void setResolver_ID(int resolver_ID) {
		this.resolver_ID = resolver_ID;
	}

	public int getStatus_ID() {
		return status_ID;
	}

	public void setStatus_ID(int status_ID) {
		this.status_ID = status_ID;
	}

	public int getType_ID() {
		return type_ID;
	}

	public void setType_ID(int type_ID) {
		this.type_ID = type_ID;
	}

}
