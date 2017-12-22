package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Annotations from org.springframework.stereotype
 * aka stereotype annotations
 * @Component - use for any bean
 * @Service - business logic layer. does NOT indicate a web service
 * @Repository - DAO layer
 */
@Component
public class Employee {
	
	private String name;
	
	@Autowired
	private Department dept;
	
	public Employee() {
		System.out.println("in employee empty constructor");
	}
	
	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
		System.out.println("in employee constructor with fields");
	}

	public String getName() {
		
		System.out.println("employee name: "+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("in employee setName");
	}

	public Department getDept() {
		System.out.println("department: "+dept.getName());
		return dept;
	}

	public void setTest(Department dept) {
		this.dept = dept;
		System.out.println("in employee setDept");
	}
	
	
	
}
