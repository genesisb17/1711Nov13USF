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
@Table(name="Bank")
public class Users {
	
	@Id
	@Column(name="u_id")
	@SequenceGenerator(allocationSize=1,name="UserSeq",sequenceName="u_SEQ")
	@GeneratedValue(generator="UserSeq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="user")
	private String user;
	
	@Column(name="pass")
	private String pass;

	@Column(name="first")
	private String first;
	
	@Column(name="last")
	private String last;
	
	@Column(name="Balance")
	private int Balance;

	public Users() {}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return Balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		Balance = balance;
	}

	public Users(String user, String pass, String first, String last, int balance) {
		super();
		this.user = user;
		this.pass = pass;
		this.first = first;
		this.last = last;
		Balance = balance;
	}
	
	
	

}
