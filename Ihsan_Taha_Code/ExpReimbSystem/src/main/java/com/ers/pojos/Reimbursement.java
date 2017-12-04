package com.ers.pojos;

public class Reimbursement
{
	private int reimbId;
	private int reimbAmount;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatusId;
	private int reimbTypeId;

	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private String reimbReceipt;

	public int getReimbId()
	{
		return reimbId;
	}

	public void setReimbId(int reimbId)
	{
		this.reimbId = reimbId;
	}

	public int getReimbAmount()
	{
		return reimbAmount;
	}

	public void setReimbAmount(int reimbAmount)
	{
		this.reimbAmount = reimbAmount;
	}

	public int getReimbAuthor()
	{
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor)
	{
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver()
	{
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver)
	{
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatusId()
	{
		return reimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId)
	{
		this.reimbStatusId = reimbStatusId;
	}

	public int getReimbTypeId()
	{
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId)
	{
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbSubmitted()
	{
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted)
	{
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved()
	{
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved)
	{
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription()
	{
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription)
	{
		this.reimbDescription = reimbDescription;
	}

	public String getReimbReceipt()
	{
		return reimbReceipt;
	}

	public void setReimbReceipt(String reimbReceipt)
	{
		this.reimbReceipt = reimbReceipt;
	}

	@Override
	public String toString()
	{
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbAuthor=" + reimbAuthor
				+ ", reimbResolver=" + reimbResolver + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId="
				+ reimbTypeId + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved=" + reimbResolved
				+ ", reimbDescription=" + reimbDescription + ", reimbReceipt=" + reimbReceipt + "]";
	}

}
