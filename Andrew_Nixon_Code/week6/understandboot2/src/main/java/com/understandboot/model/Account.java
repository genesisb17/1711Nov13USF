package com.understandboot.model;

import java.io.Serializable;

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
@Table(name="ACCOUNTS")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6814800912997558085L;

	@Id
	@Column(name="ACC_ID")
	@SequenceGenerator(name="ACC_SEQ", sequenceName="ACC_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACC_SEQ")
	private Integer id;
	
	@Column(name="ACC_LN", nullable=false)
	private String ln;
	
	@Column(name="ACC_fN", nullable=false)
	private String fn;
	
	@Column(name="ACC_EMAIL", nullable=false)
	private String email;
	
	@Column(name="ACC_PASSWORD", nullable=false)
	private String password;
	
	@Column(name="ACC_BALANCE", nullable=false)
	private Double balance;

	public Account() {
		super();
	}

	public Account(String ln, String fn, String email, String password, Double balance) {
		super();
		this.ln = ln;
		this.fn = fn;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public Account(Integer id, String ln, String fn, String email, String password, Double balance) {
		super();
		this.id = id;
		this.ln = ln;
		this.fn = fn;
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

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", ln=" + ln + ", fn=" + fn + ", email=" + email + ", password=" + password
				+ ", balance=" + balance + "]";
	}

}
