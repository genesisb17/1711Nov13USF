package com.rev.pojos;

public class AccountRegistrar {

	private int userId;
	private int acctId;
	private String userPrivilege;
	
	
	public AccountRegistrar() {}
	
	/**
	 * @param userId
	 * @param acctId
	 */
	public AccountRegistrar(int userId, int acctid) {
		super();
		this.userId = userId;
		this.acctId = acctid;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the acctId
	 */
	public int getAcctId() {
		return acctId;
	}

	/**
	 * @param acctId the acctId to set
	 */
	public void setAcctId(int acctid) {
		this.acctId = acctid;
	}
	
	/**
	 * @return the userPrivilege
	 */
	public String getUserPrivilege() {
		return userPrivilege;
	}

	/**
	 * @param userPrivilege the userPrivilege to set
	 */
	public void setUserPrivilege(String userPrivilege) {
		this.userPrivilege = userPrivilege;
	}
	
}
