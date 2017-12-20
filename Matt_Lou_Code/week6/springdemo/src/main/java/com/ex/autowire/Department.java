package com.ex.autowire;

import org.springframework.stereotype.Component;

@Component
public class Department {
	private String name;

	public Department() {
		System.out.println("in department empty constructor");
	}
	
	public Department(String name) {
		super();
		System.out.println("in department fields constructor");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("in department setName");
		this.name = name;
	}
	
	
}
