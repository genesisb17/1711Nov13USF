package com.rev.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="ACC_ID", nullable=false)
	@SequenceGenerator(allocationSize=1, name="ACC_SEQ", sequenceName="ACC_SEQ")
	@GeneratedValue(generator="ACC_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer accId;
	
	@Column(name="ACC_TYPE", nullable=false)
	private String accountType;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Column(name="BALANCE")
	private Double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountType, User user, Double balance) {
		super();
		this.accountType = accountType;
		this.user = user;
		this.balance = balance;
	}

	public Account(Integer accId, String accountType, User user, Double balance) {
		super();
		this.accId = accId;
		this.accountType = accountType;
		this.user = user;
		this.balance = balance;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accountType=" + accountType + ", user=" + user + ", balance=" + balance
				+ "]";
	}

}
