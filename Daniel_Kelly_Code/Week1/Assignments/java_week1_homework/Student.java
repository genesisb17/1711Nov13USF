package com.revature.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {

	String name;
	String department;
	int age;

	public static void main(String[] args) {

		ArrayList<Student> al = new ArrayList<Student>();

		al.add(new Student("Matt", "Physics", 29));
		al.add(new Student("Daniel", "World History", 26));

		System.out.println("Sorting by Name...");

		Collections.sort(al, new SortbyName());
		for (Student st : al) {
			System.out.println(st.toString());
		}

		System.out.println("Sorting by Department...");
		Collections.sort(al, new SortbyDepartment());	
		for (Student st : al) {
			System.out.println(st.toString());
		}
		
		System.out.println("Sorting by Age...");
		Collections.sort(al, new SortbyAge());
		for (Student st : al) {
			System.out.println(st.toString());
		}	
		
	}

	public Student() {

	}

	public Student(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Department: " + department + "\n" + "Age: " + age + "\n";
	}

}

class SortbyName implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		return a.name.compareTo(b.name);
	}

}

class SortbyDepartment implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		return a.department.compareTo(b.department);
	}
}

class SortbyAge implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		return a.age - b.age;
	}
}
