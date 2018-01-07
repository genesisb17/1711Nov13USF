package com.rev.banking.domain;

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
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="U_SEQ", sequenceName="U_SEQ", initialValue=2000000, allocationSize=1)
	@GeneratedValue(generator="U_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer userId;
	
	@Column(name="FIRSTNAME", nullable=false)
	private String firstname;
	
	@Column(name="LASTNAME", nullable=false)
	private String lastname;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="BALANCE", nullable=false)
	private Double balance;
	
	public User() {}

	public User(String firstname, String lastname, String email, String username, String password, Double balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public User(Integer userId, String firstname, String lastname, String email, String username, String password,
			Double balance) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", balance=" + balance + "]";
	}
}
