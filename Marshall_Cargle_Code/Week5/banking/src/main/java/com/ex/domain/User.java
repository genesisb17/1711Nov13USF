package com.ex.domain;

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
	@Column(name = "user_id")
	@SequenceGenerator(allocationSize = 1, name = "userSeq", sequenceName = "USER_SEQ")
	@GeneratedValue(generator = "userSeq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "first_name")
	private String fn;

	@Column(name = "last_name")
	private String ln;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "balance")
	private Double balance;

	public User() {
	}
	
	public User(Integer id) {
		super();
		this.id=id;
	}

	public User(Integer id, String fn, String ln, String email, String password, Double balance) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public User(String fn, String ln, String email, String password, Double balance) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", email=" + email + ", password=" + password
				+ ", balance=" + balance + "]";
	}

}
