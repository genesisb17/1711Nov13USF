package com.ex.autowired;

public class Department 
{
	private String name;

	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}
	public Department() {
		super();
		System.out.println("in dept constructor empty");
	}
	public Department(String name) {
		super();
		System.out.println("in dept constructor");
		this.name = name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
