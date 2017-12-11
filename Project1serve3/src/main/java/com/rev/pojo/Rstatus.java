package com.rev.pojo;

public class Rstatus 
{
	private int statusid;
	private String Rstatus;
	/**
	 * @return the statusid
	 */
	public int getStatusid() {
		return statusid;
	}
	/**
	 * @param statusid the statusid to set
	 */
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	/**
	 * @return the rstatus
	 */
	public String getRstatus() {
		return Rstatus;
	}
	/**
	 * @param rstatus the rstatus to set
	 */
	public void setRstatus(String rstatus) {
		Rstatus = rstatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Rstatus [statusid=" + statusid + ", Rstatus=" + Rstatus + "]";
	}
	
}
