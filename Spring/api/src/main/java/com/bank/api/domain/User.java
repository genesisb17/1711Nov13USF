package com.bank.api.domain;

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
	@SequenceGenerator(allocationSize=1,name="userSeq",sequenceName="USER_SEQ")
	@GeneratedValue(generator="userSeq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="USER_FIRSTNAME", nullable = false)
	private String firstname;
	
	@Column(name="USER_LASTNAME", nullable = false)
	private String lastname;
	
	@Column(name="USER_EMAIL", unique=true)
	private String email;
	
	@Column(name="USER_PASSWORD", nullable = false)
	private String password;
	
	@Column(name="USER_BALANCE")
	private double balance;
	
	public User() {}
	
	public User(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.balance = 0.0;
	}

	public User(Integer id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	

	public User(String firstname, String lastname, String email, String password, double balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}
