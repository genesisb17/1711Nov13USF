package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String name;
	
	@Autowired
	private Department dept;
	
	public Employee() {
		System.out.println("In employee empty constructor");
	}

	public Employee(String name, Department dept) {
		super();
		System.out.println("In employee constructor using fields");

		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		System.out.println("employee name -> " + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("In employee setName");

		this.name = name;
	}

	public Department getDept() {
		System.out.println("department -> " + dept);
		return dept;
	}

	public void setDept(Department dept) {
		System.out.println("In employee setDept");
		this.dept = dept;
	}

	
	
}
