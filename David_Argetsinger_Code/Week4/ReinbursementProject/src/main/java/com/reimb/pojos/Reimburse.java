package com.reimb.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimburse {

	
	
public Reimburse() {
		super();
	}

public Reimburse(int id, double amount, String submitted, String resolved, String desc, Blob receipt,
			int author, int resolver, int status, int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
@Override
	public String toString() {
		return "Reimburse [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", desc=" + desc + ", receipt=" + receipt + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}
private int id;
private double amount;
private String submitted;
private String resolved;
private String desc;
private Blob receipt;
private int author;
private int resolver;
private int status;
private int type;
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
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
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


}
