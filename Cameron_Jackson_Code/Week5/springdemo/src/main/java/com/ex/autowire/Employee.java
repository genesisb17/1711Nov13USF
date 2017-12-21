package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * annotations from org.springframework.stereotype
 * aka stereotype annotations
 * @Component - use for any bean
 * @Service - business logic layer. does NOT indicate a web service
 * @Repository - DAO layer
 */
@Component
@Scope("prototype")
public class Employee {
	
	private String name;
	
	@Autowired
	private Department dept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("in empl empty constr");
	}
	
	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
		System.out.println("in empl constr using fields");
	}

	public String getName() {
		System.out.println("in empl getname() "+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("in empl setname()");
	}

	public Department getDept() {
		System.out.println("in empl getdept() "+dept);
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
		System.out.println("in empl setdept()");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + "]";
	}
}
