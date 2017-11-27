package com.homework.java;

//POJO = Plain Ol' Java Object
public class Student {
	
	/**
	 * The serialVersionUID is used as a version control in
	 * a Serializable class. If you do not explicitly declare one,
	 * the JVM will do it for you based on various aspects of your 
	 * Serializable class.
	 */
	
	private String fn, ln, location;
	private int age;
	
	public Student(String name, String lname, int age, String location) {
		super();
		this.fn = name;
		this.ln = lname;
		this.age = age;
		this.location = location;
	}

	public Student() {
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
	
	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}
	
	public String getLocation() {
		return location;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		
		return fn + ":"  + ln + ":" + age + ":" + location + "\n";
		
	}
	
	
}
