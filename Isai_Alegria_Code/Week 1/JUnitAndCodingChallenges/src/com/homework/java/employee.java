package com.homework.java;

//POJO = Plain Ol' Java Object
public class employee {
	
	
	private String fn, ln, department;
	private int age;
	
	public employee(String name, String lname, int age, String department) {
		super();
		this.fn = name;
		this.ln = lname;
		this.age = age;
		this.department = department;
	}

	public employee() {
		// TODO Auto-generated constructor stub
	}

	public String getfName() {
		return fn;
	}
	
	public String getlName() {
		return ln;
	}

	public void setfName(String name) {
		this.fn = name;
	}
	
	public void setlName(String name) {
		this.ln= name;
		
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		
		return fn + ":"  + ln + ":" + age + ":" + department + "\n";
		
	}
	
	
}
