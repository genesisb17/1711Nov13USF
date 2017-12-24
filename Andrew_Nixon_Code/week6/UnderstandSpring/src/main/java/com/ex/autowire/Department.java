package com.ex.autowire;

import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private String name;
	
	public Department() {
		super();
		System.out.println("in Department empty con");
	}

	public Department(String name) {
		super();
		this.name = name;
		System.out.println("in Department full con");
	}

	public String getName() {
		System.out.println("Department Name: " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("in Department setName");
	}
	
	
	
}
