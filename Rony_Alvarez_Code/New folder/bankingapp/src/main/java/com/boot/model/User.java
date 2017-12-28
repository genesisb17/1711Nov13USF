package com.boot.model;

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
	@Column(name="u_id")
	@SequenceGenerator(allocationSize=1, name="usersSeq", sequenceName="U_SEQ")
	@GeneratedValue(generator="usersSeq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="u_firstname")
	private String firstname;
	
	@Column(name="u_lastname")
	private String lastname;
	
	@Column(name="u_email", nullable=false)
	private String email;
	
	@Column(name="u_password", nullable=false)
	private String password;
	
	@Column(name="u_balance")
	private Double balance;
	
	public User() {}

	public User(String firstname, String lastname, String email, String password, Double balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public User(Integer id, String firstname, String lastname, String email, String password, Double balance) {
		super();
		this.id = id;
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", balance=" + balance + "]";
	}
	
	
	
}
