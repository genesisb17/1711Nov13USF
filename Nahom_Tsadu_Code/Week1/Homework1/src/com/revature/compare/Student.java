package com.revature.compare;

public class Student {

	private String name;
	private String department;
	private int age;
	
	public Student(String n, String d, int a){
		this.name = n;
		this.department = d;
		this.age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
