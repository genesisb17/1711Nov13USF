package com.rev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="userId")
	@SequenceGenerator(allocationSize = 1, name = "userSeq", sequenceName = "USER_SEQ")
	@GeneratedValue(generator = "userSeq", strategy = GenerationType.SEQUENCE)
	private Integer userId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pnumber")
	private String pnumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private Integer role;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String pnumber, String password, Integer role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pnumber = pnumber;
		this.password = password;
		this.role = role;
	}

	public User(Integer userId, String firstName, String lastName, String email, String pnumber, String password,
			Integer role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pnumber = pnumber;
		this.password = password;
		this.role = role;
	}
	
	

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getId() {
		return userId;
	}

	public void setId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", pnumber=" + pnumber + ", password=" + password + ", role=" + role + "]";
	}

}
