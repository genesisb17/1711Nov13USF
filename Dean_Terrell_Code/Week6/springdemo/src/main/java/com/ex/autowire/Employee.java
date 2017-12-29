package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String name;
	
	@Autowired
	private Department dept;
	
	public Employee() {
		System.out.println("In empty employee constructor");
	}
	
	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
		
		System.out.println("In fields employee constructor");
	}

	public String getName() {
		System.out.println("In employee getName: " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("In employee setName");
	}

	public Department getDept() {
		System.out.println("In employee getDept: " + dept.getName());
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
		System.out.println("In employee setDept");

	}
	
	
}
