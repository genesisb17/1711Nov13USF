package com.revature.day4;

public class People {
	private String firstname;
	private String lastname;
	private int age;
	private String location;
	
	public People(){
		
	}
	
	public People(String name, String lname, int age, String location) {
		super();
		this.firstname = name;
		this.lastname = lname;
		this.age = age;
		this.location = location;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String name) {
		this.firstname = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Name: " + firstname + " " + lastname + "\n" + "Age: " + age + "\n" + "State: " + location + "\n";
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
