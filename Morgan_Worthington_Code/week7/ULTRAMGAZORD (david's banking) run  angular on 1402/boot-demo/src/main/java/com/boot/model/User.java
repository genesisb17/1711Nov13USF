package com.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="Users",
	uniqueConstraints=
	@UniqueConstraint(columnNames={"USERNAME"})
)
public class User {
	
	@Id
	@Column(name="u_id")
	@SequenceGenerator(allocationSize=1,name="useq",sequenceName="U_SEQ")
	@GeneratedValue(generator="useq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	//FIRSTNAME, LASTNAME, USERNAME, PASSWORD, BALANCE)
//	@Column(name="fc_question")
//	private String question;
	@Column(name="FIRSTNAME", nullable=false)
	private String firstname;
	
	@Column(name="LASTNAME", nullable=false)

	private String lastname;
	
	@Column(name="USERNAME", nullable=false, unique=true)

	private String username;
	
	@Column(name="PASSWORD", nullable=false)

	private String password;
	
	@Column(name="BALANCE", nullable=false)

	private Double balance;

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

	public User(String firstname, String lastname, String username, String password, Double balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public User(Integer id, String firstname, String lastname, String username, String password, Double balance) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
