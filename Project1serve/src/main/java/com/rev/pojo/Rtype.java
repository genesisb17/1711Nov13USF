package com.rev.pojo;

public class Rtype 
{
	private int typeid;
	private String Rtype;
	/**
	 * @return the typeid
	 */
	public int getTypeid() {
		return typeid;
	}
	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	/**
	 * @return the rtype
	 */
	public String getRtype() 
	{
		return Rtype;
	}
	/**
	 * @param rtype the rtype to set
	 */
	public void setRtype(String rtype) {
		Rtype = rtype;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Rtype [typeid=" + typeid + ", Rtype=" + Rtype + "]";
	}
	
}
