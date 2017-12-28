package com.ex.autowire;

import org.springframework.stereotype.Component;

@Component
public class Department {

	private String name;
	
	public Department() {
		System.out.println("In dept empty constructor");
	}

	public Department(String name) {
		super();
		System.out.println("In dept constructor using field");

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("In set name");
		this.name = name;
	}
	
	
	
}
