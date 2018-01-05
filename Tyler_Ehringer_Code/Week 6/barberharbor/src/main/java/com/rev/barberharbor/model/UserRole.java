package com.rev.barberharbor.model;

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
@Table(name="USER_ROLES")
public class UserRole implements Serializable{

	private static final long serialVersionUID = 948024833954123354L;
	
	@Id
	@Column(name="USER_ROLES_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="ROLE_SEQ", sequenceName="ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_SEQ")
	private Long id;
	
	@Column(name="ROLE")
	private String role;

	public UserRole() {
		super();
	}

	public UserRole(String role) {
		super();
		this.role = role;
	}

	public UserRole(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
