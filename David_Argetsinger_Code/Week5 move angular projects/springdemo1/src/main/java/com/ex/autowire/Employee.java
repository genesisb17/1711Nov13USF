package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * annotations from or.springframrwork .streotype
 * ak sterotype annotations 
 * @compoenent for ean bean
 * @service for buisiness logic error 
 * does not indicate web service 
 * @repository for DAO layer 
 */
@Component
public class Employee {
	private String   name;
	@Autowired
	private Department department;
	public String getName() {
		System.out.println("in getname " +name);
		return name;
	}
	public void setName(String name) {
		System.out.println("in setname");
		this.name = name;
	}

	public Department getDepartment() {
		System.out.println("department: " + getName());
		return department;
	}
	public void setDepartment(Department department) {		
		this.department = department;
		System.out.println("in employee setDepartment");
	}
	public Employee() {
		super();
		System.out.println("in empty const");
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, Department department) {
		super();
		System.out.println("in fielded const");
		this.name = name;
		this.department = department;
	}

}
