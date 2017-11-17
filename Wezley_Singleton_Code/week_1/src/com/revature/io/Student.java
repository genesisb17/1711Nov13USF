package com.revature.io;

import java.io.Serializable;

//POJO:Plain Ol' Java Object
public class Student implements Serializable {

	/**
	 *  The serialVersionUID is used as a version control in a Serializable class.
	 *  If you do not explicitly declare one, the JVM will do it for you based on 
	 *  various aspects of your Serializable class.
	 */
	private static final long serialVersionUID = -1706602523015578910L;
	
	// the transient keyword makes a given member un-serializable
	private String name;
	private int age;
	
	
	/**
	 * no-arg constructor
	 */
	public Student() {
		super();
	}
	
	/**
	 * @param name
	 * @param age
	 */
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ":" + age + "\n";
	}
	
}
