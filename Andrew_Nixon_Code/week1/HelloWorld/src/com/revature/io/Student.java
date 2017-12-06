package com.revature.io;

import java.io.Serializable;

//POJO
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1238382953925487328L;
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ":" + age  + "\n";	}
	
	

}
