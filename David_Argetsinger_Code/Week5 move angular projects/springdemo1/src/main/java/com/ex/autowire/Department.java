package com.ex.autowire;

import org.springframework.stereotype.Component;



@Component
public class Department {
	private String  name;

	public Department() {
		super();
		System.out.println("in empty constructor");
		// TODO Auto-generated constructor stub
	}

	public Department(String name) {
		super();

		System.out.println("in name + constructor ");
		this.name = name;
	}

	public String getName() {

		System.out.println("in getname");
		return name;
	}

	public void setName(String name) {

		System.out.println("in setname");
		this.name = name;
	}
}
