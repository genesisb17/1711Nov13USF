package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Department {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("In dept setname");
		this.name = name;
	}

	public Department(String name) {
		super();
		System.out.println("In dept constructor with fields");
		this.name = name;
	}

	public Department() {
		super();
		System.out.println("in department empty constructor");
	}

}
