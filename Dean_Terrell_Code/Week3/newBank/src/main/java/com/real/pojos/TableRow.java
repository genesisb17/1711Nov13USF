package com.real.pojos;

public class TableRow {
	
	private int reimb_id;
	private String status;
	private double amount;
	private String type;
	private String date;
	private String description;
	private String fName;
	private String lName;
	private String date2;
	
	public TableRow() {}
	
	public TableRow(int reimb_id, String status, double amount, String type,
			String date, String description, String fName, String lName, String date2) {
		super();
		this.reimb_id = reimb_id;
		this.status = status;
		this.amount = amount;
		this.type = type;
		this.date = date;
		this.description = description;
		this.fName = fName;
		this.lName = lName;
		this.date2 = date2;
	}

	
	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate2() {
		return date2;
	}

	public void setDate2(String date) {
		this.date = date2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "TableRow [reimb_id=" + reimb_id + ", status=" + status
				+ ", amount=" + amount + ", type=" + type + ", date=" + date
				+ ", description=" + description + ", fName=" + fName
				+ ", lName=" + lName + "]";
	}
	
	
}