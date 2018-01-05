package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class Employee {

	private String name;
	
	@Autowired
	private Department dept;

	public Employee() {
		super();
		System.out.println("in employee empty constructor");
	}

	public Employee(String name, Department department) {
		super();
		System.out.println("In employee field constructor");
		this.name = name;
		this.dept = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("In employee setName");
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department department) {
		this.dept = department;
		System.out.println("in employee setDept");
	}

}
