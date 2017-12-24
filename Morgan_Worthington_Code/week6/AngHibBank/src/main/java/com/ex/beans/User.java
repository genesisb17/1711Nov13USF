package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BANK_USERS")
public class User {
	
	@Id
	@Column(name="BANK_USERS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String fn;
	private String ln;
	private String username;
	private String pw;
	private double balance;
	
	public User() {}
	
	public User(int id, String fn, String ln, String username, String pw, double balance) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.username = username;
		this.pw = pw;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFn() {
		return fn;
	}
	
	public void setFn(String fn) {
		this.fn = fn;
	}
	
	public String getLn() {
		return ln;
	}
	
	public void setLn(String ln) {
		this.ln = ln;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
