package com.springboot.model;

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
@Table(name="PeopleKnowerUser")
public class PeopleKnower 
{
	@Id
	@Column(name="pk_id")
	@SequenceGenerator(allocationSize=1,name="PeopleKnowerSeq",sequenceName="PK_SEQ")
	@GeneratedValue(generator="PeopleKnowerSeq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public PeopleKnower(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;

	}
	public PeopleKnower() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}