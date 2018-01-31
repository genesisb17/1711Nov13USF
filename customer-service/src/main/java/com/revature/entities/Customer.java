package com.revature.entities;

import java.util.List;

public class Customer 
{
	private int id;
	private String name;
	private List<Accounts>accounts;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accounts=" + accounts + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the accounts
	 */
	public List<Accounts> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}
	public Customer(int id, String name, List<Accounts> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}
	
	public Customer() 
	{
		super();
	}

}
