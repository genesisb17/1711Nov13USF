package com.revature.io;

import java.io.Serializable;

//POJO = Plain Ol' Java Object
public class Student implements Serializable {
	
	/**
	 * The serialVersionUID is used as a version control in a 
	 * Serializable class. If you do not explicitly declare one, 
	 * the JVM will do it for you based on various aspects of 
	 * your Serializable class
	 */
	//private static final long serialVersionUID = -1706602523015578910L;
	
	
	private String name;
	private int age;
	
	public Student(){} 
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		return name + ":" + age + "\n";
	}
	
	
	
	

}
