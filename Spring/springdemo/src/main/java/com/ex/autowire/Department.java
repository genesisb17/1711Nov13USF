package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Department {
	
	private String name;

	
	public Department(String name) {
		super();
		System.out.println("In dept constructor using fields");
		this.name = name;
	}
	
	public Department() {
		System.out.println("In dept empty constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("in dept setName");
		this.name = name;
	}
	
	

}
