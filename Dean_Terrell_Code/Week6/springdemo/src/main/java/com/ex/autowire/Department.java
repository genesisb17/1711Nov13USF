package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private String name;

	public Department() {
		System.out.println("In empty dept constructor");
	}
	
	public Department(String name) {
		super();
		this.name = name;
		
		System.out.println("In fields dept constructor");
	}

	public String getName() {
		System.out.println("In dept get name");
		return name;
	}

	public void setName(String name) {
		System.out.println("In dept set name");
		this.name = name;
	}
	
	
}
