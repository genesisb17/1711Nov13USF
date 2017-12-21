package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Annotations from org.springframework.stereotype
 * aka: stereotype annotations
 * @Component - use for any bean
 * @Service - business logic layer. does NOT indicate a web service 
 * @Repository - DAO layer
 */
@Component
@Scope("prototype")
public class Employee {
	
	private String name;
	
	@Autowired
	private Department department;
	
	public Employee() {
		System.out.println("in employee empty constructor");
	}
	
	public Employee(String name, Department department) {
		super();
		System.out.println("in employee fields constructor");
		this.name = name;
		this.department = department;
	}
	public String getName() {
		System.out.println("employee name: " + name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("in employee setName");
	}
	public Department getDepartment() {
		System.out.println("department: " + getName());
		return department;
	}
	public void setDepartment(Department department) {		
		this.department = department;
		System.out.println("in employee setDepartment");
	}
	
	
}
