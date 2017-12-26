package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * Annotations from
 * 
 * @Component - use this for any bean
 * @Service   - business logic layer. does NOT indicate a web service
 * @Repository- DAO layer
 */
@Component
public class Employee {
	
	private String name;
	
	@Autowired
	private Department dept;
	public String getName() {
		System.out.println(" in employess get name : " + name);
		return name;
	}
	public void setName(String name) {
		System.out.println(" in employee setName ");
		this.name = name;
	}
	public Department getDept() {
		System.out.println(" in employee get dept : " + dept.getName());
		return dept;
	}
	public void setDept(Department dept) {
		System.out.println( " in employee set dept ");
		this.dept = dept;
	}
	
	//public void setTest()
	public Employee(String name, Department dept) {
		super();
		System.out.println(" in employee field constructor ");
		this.name = name;
		this.dept = dept;
	}
	
	public Employee() {System.out.println(" in employee empty constructor ");}

}