package com.ex.autowired;

import org.springframework.stereotype.Component;

/*
 * 
 * Annotations from org.springframework.stereotype
 * aka stereotype annotations
 * @Component - use for any bean
 * @Service-business login layer, does not indicate a web service
 * 
 * 
 */
@Component
public class Employee 
{
	private String name;
	private Department dept;
	public Employee()
	{
		System.out.println("in employee empty constructor");
	}
	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
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
	 * @return the depart
	 */
	public Department getDepart() {
		return dept;
	}
	/**
	 * @param depart the depart to set
	 */
	public void setDepart(Department depart) {
		this.dept = depart;
	}
}