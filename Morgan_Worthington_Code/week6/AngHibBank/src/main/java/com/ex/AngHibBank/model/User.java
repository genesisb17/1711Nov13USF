package com.ex.AngHibBank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BANK_USERS")
public class User {
	
	@TableGenerator(name="user_gen",table="GEN_ID",pkColumnName="GEN_NAME",valueColumnName="GEN_VAL",allocationSize=1)
	@Id
	@Column(name="BANK_USERS_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="user_gen")
	private Integer id;

	private String FN;

	private String LN;

	@Column(name="USERNAME")
	private String username;

	private String PW;

	private double BALANCE;
	
	public User() {
		this.id=0;
	}
	
	public User(int id, String fn, String ln, String username, String pw, double balance) {
		super();
		this.id = id;
		this.FN = fn;
		this.LN = ln;
		this.username = username;
		this.PW = pw;
		this.BALANCE = balance;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFn() {
		return FN;
	}
	
	public void setFn(String fn) {
		this.FN = fn;
	}
	
	public String getLn() {
		return LN;
	}
	
	public void setLn(String ln) {
		this.LN = ln;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPw() {
		return PW;
	}
	
	public void setPw(String pw) {
		this.PW = pw;
	}
	
	public double getBalance() {
		return BALANCE;
	}
	
	public void setBalance(double balance) {
		this.BALANCE = balance;
	}
	
}
