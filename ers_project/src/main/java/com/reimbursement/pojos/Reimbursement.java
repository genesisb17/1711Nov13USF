package com.reimbursement.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {

	private Integer reimbId;
	private Integer reimbAmount;
	private String reimbSubmitted; 
	private String reimbResolved;
	private String reimbDescription;
	private String reimbReceipt;
	private Integer reimbAuthor;
	private Integer reimbResolver;
	private Integer reimbStatId;
	private Integer reimbTypeId;
	private String author;
	private String resolver;
	private String rType;
	private String rStat;
//	private String timeS;
//	private String timeR;

	public Reimbursement() {
		
	}
	
	public Reimbursement(Integer reimbId, Integer reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, String reimbReceipt, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatId,
			Integer reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatId = reimbStatId;
		this.reimbTypeId = reimbTypeId;

	}

	public Integer getReimbId() {
		return reimbId;
	}

	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}

	public Integer getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(Integer reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(String string) {
		this.reimbReceipt = string;
	}

	public Integer getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(Integer reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public Integer getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(Integer reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public Integer getReimbStatId() {
		return reimbStatId;
	}

	public void setReimbStatId(Integer reimbStatId) {
		this.reimbStatId = reimbStatId;
	}

	public Integer getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(Integer reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public String getrStat() {
		return rStat;
	}

	public void setrStat(String rStat) {
		this.rStat = rStat;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatId=" + reimbStatId + ", reimbTypeId=" + reimbTypeId + ", author=" + author + ", resolver="
				+ resolver + ", rType=" + rType + ", rStat=" + rStat + "]";
	}

//	public String getTimeS() {
//		return timeS;
//	}
//
//	public void setTimeS(String timeS) {
//		this.timeS = timeS;
//	}
//
//	public String getTimeR() {
//		return timeR;
//	}
//
//	public void setTimeR(String timeR) {
//		this.timeR = timeR;
//	}

	
}
