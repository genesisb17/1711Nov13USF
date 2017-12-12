package com.rev.pojos;

import java.awt.Image;
import java.sql.Timestamp;

public class Reimbursement {

	private int id, authorId, resolverId, status, type;
	private double amount;
	private Timestamp submitted, resolved;
	private String description;
	private Image receipt;

	public static final int STATUS_PENDING = 1;
	public static final int STATUS_APPROVED = 2;
	public static final int STATUS_DENIED = 3;

	public static final int TYPE_LODGING = 1;
	public static final int TYPE_TRAVEL = 2;
	public static final int TYPE_FOOD = 3;
	public static final int TYPE_OTHER = 4;

	public Reimbursement(int authorId, int type, double amount, String description) {
		this(authorId, type, amount, description, null);
	}

	public Reimbursement(int authorId, int type, double amount, String description, Image receipt) {
		this(0, authorId, 0, STATUS_PENDING, type, amount, new Timestamp(0), new Timestamp(0), description, receipt);
	}

	public Reimbursement(int id, int authorId, int resolverId, int status, int type, double amount, Timestamp submitted,
			Timestamp resolved, String description, Image receipt) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.status = status;
		this.type = type;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
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

	public Image getReceipt() {
		return receipt;
	}

	public void setReceipt(Image receipt) {
		this.receipt = receipt;
	}

}
