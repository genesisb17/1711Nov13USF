package com.rev.pojos;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	private int id;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int status;
	private int type;
	private String authorStr;
	private String resolverStr;
	private String statusStr;
	private String typeStr;
	

	public Reimbursement() {}
	
	public Reimbursement(int id, double amount, String submitted, String resolved, String description, Blob receipt,
			int author, int resolver, int status, int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	public Reimbursement(int id, double amount, String submitted, String resolved, String description, Blob receipt,
			int author, int resolver, int status, int type, String authorStr, String resolverStr, String statusStr,
			String typeStr) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
		this.authorStr = authorStr;
		this.resolverStr = resolverStr;
		this.statusStr = statusStr;
		this.typeStr = typeStr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
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
	public String getAuthorStr() {
		return authorStr;
	}
	public void setAuthorStr(String authorStr) {
		this.authorStr = authorStr;
	}
	public String getResolverStr() {
		return resolverStr;
	}
	public void setResolverStr(String resolverStr) {
		this.resolverStr = resolverStr;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + ", authorStr=" + authorStr + ", resolverStr="
				+ resolverStr + ", statusStr=" + statusStr + ", typeStr=" + typeStr + "]";
	}

}
