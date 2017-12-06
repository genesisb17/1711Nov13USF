package com.revature.assignments;

public class Employees {
	
	private String name;
	private String department;
	private int age;
	
	public Employees() {}
	
	public Employees(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
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

	@Override
	public String toString() {
		return "Employee: name = " + name + ", department = " + department + ", age = " + age;
	}
	
	

}
