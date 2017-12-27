package com.rev.bootbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USERS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "U_SEQ", sequenceName = "U_SEQ")
	@GeneratedValue(generator = "U_SEQ", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "USERS_USERNAME", unique=true, nullable=false)
	private String username;

	@Column(name = "USERS_PASSWORD")
	private String password;

	@Column(name = "USERS_FNAME")
	private String fname;

	@Column(name = "USERS_LNAME")
	private String lname;
	
	@Column(name="USERS_BALANCE")
	private double balance = 0.0;

	public User() {
		super();
	}

	public User(String username, String password, String fname, String lname) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public User(Long id, String username, String password, String fname, String lname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
