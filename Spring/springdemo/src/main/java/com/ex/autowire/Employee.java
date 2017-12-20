package com.ex.autowire;

public class Employee {
	
	private String name;
	private Department dept;
	
	public Employee(){
		System.out.println("in employee empty constructor");
	}
	
	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
		System.out.println("in employee constructor from fields");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("in employee setName");
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
		System.out.println("in employee setDept");
	}
	
	
	

}
