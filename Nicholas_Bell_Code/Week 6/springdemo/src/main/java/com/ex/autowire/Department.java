package com.ex.autowire;

import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private String name;

	public String getName() {
		System.out.println(" in dept get name :" + name);
		return name;
	}

	public void setName(String name) {
		System.out.println(" in dept set name ");
		this.name = name;
	}

	public Department(String name) {
		super();
		System.out.println(" in Department fields constructor ");
		this.name = name;
	}
	
	public Department() {System.out.println(" in empty department constructor ");}
	
}
