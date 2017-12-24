package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String name;
	@Autowired
	private Department dept;
		
	public Employee() {
		super();
		System.out.println("in Employee empty con");
	}

	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
		System.out.println("in Employee full con");

	}
	
	public String getName() {
		System.out.println("Employee Name: " + name);
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("in Employee setName");
	}
	
	public Department getDept() {
		dept.getName();
		return dept;
	}
	
	public void setDept(Department dept) {
		this.dept = dept;
		System.out.println("in Employee setDept");
	}
	

}
