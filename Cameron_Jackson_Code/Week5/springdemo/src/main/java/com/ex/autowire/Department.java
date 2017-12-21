package com.ex.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Department {

	private String name;

	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("in dept empty constr");
	}


	public Department(String name) {
		super();
		this.name = name;
		System.out.println("in dept constr from fields");
	}


	public String getName() {
		System.out.println("in dept getname() "+name);
		return name;
	}


	public void setName(String name) {
		this.name = name;
		System.out.println("in dept setname()");
	}


	@Override
	public String toString() {
		return "Department [name=" + name + "]";
	}
}
