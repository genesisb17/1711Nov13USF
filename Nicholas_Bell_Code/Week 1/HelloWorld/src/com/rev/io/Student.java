package com.rev.io;
//we will generally not have this in the same package as the IO file

import java.io.Serializable;

//POJO PLain old java object
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8424536827080713780L;
	/**
	 * the serialVersionUID is used as a version control in a 
	 * serializable class. if you do not explicitly declare one,
	 * the JVM will do it for you based on various aspects of your Serializable class
	 */
	
	//the keyword "transient" 
	
	
	private String name;
	private int age;
	
	public Student() {}
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
