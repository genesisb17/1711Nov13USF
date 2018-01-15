package com.reimb.pojos;
//make this the one that  has username insteadof ID and type and status instead of numbers 
// u.u 
// sad days team 

public class ReimburseLog {
private int id; 
private String username;
private String fname;
private String lname;
private String rstatus;
private double amount;
private String desc;
private String rtype;
private String date;
private String resolver; 
private String resolved;
//going to user get user by uname to update
public int getId() {
	return id;
}
public ReimburseLog() {
	super();
}
public ReimburseLog(int id, String username, String fname, String lname, String rstatus, double amount, String desc,
		String rtype, String date, String resolver, String resolved) {
	super();
	this.id = id;
	this.username = username;
	this.fname = fname;
	this.lname = lname;
	this.rstatus = rstatus;
	this.amount = amount;
	this.desc = desc;
	this.rtype = rtype;
	this.date = date;
	this.resolver = resolver;
	this.resolved = resolved;
}
@Override
public String toString() {
	return "ReimburseLog [id=" + id + ", username=" + username + ", fname=" + fname + ", lname=" + lname + ", rstatus="
			+ rstatus + ", amount=" + amount + ", desc=" + desc + ", rtype=" + rtype + ", date=" + date + ", resolver="
			+ resolver + ", resolved=" + resolved + "]";
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getRstatus() {
	return rstatus;
}
public void setRstatus(String rstatus) {
	this.rstatus = rstatus;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getRtype() {
	return rtype;
}
public void setRtype(String rtype) {
	this.rtype = rtype;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getResolver() {
	return resolver;
}
public void setResolver(String resolver) {
	this.resolver = resolver;
}
public String getResolved() {
	return resolved;
}
public void setResolved(String resolved) {
	this.resolved = resolved;
}
}
