package com.revature.io;

import java.io.Serializable;

//POJO = Plain Ol' Java Object
public class Student implements Serializable {

	/**
	 * The serialVersionUID is used as a version control in a 
	 * Serializable class. If you do not explicitly declare one,
	 * the JVM will do it for you based on various aspects of
	 * your Serializable class.
	 * If declared 'transient' the member will not serialize with
	 * rest of the object. When de-serialized the transient member
	 * will be restored to default value.
	 */
	private static final long serialVersionUID = -1706602523015578910L;
	
	private String firstname;
	private String lastname;
	private int age;
	private String state;
	
	public Student() {}
	
	public Student(String fname, String lname, int age, String state) {
		super();
		this.firstname = fname;
		this.lastname = lname;
		this.age = age;
		this.state = state;
	}

	public String getName() {
		return this.firstname.concat(" " + this.lastname);
	}

	public void setName(String fname, String lname) {
		this.firstname = fname;
		this.lastname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void formattedPrint() {
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge() + " years");
		System.out.println("State: " + this.getState() + " state\n");
	}

	@Override
	public String toString() {
		return this.getName() + ":" + this.getAge() + ":" +  this.getState() + "\n";
	}
	
}
