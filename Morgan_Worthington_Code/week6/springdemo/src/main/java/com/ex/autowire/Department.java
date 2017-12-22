package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Department {

	private String name;
	
	public Department() {
		System.out.println("in department empty constructor");
	}

	public Department(String name) {
		super();
		this.name = name;
		System.out.println("in department constructor with fields");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("in department setName");
	}
	
	
	
}
