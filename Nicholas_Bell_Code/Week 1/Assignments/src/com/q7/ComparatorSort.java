package com.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.q7.Employee.Comparer;

public class ComparatorSort {
	
	public static void main(String[] args) {
		
		//Create Employees
		Employee e1 = new Employee("Jan", "Accounting", 65);
		Employee e2 = new Employee("Alfie" , "Shipping", 42);
		Employee e3 = new Employee("Wanda", "Marketing" , 25);
		
		//add to list
		ArrayList<Employee> roster = new ArrayList<Employee>();
		roster.add(e1);
		roster.add(e2);
		roster.add(e3);
		
		//sort by name
		Collections.sort(roster, new Employee.Comparer.nameCompare());
		System.out.println(roster);
		
		// ''  '' department
		Collections.sort(roster, new Employee.Comparer.departmentCompare());
		System.out.println(roster);
		
		// ''  '' age
		Collections.sort(roster, new Employee.Comparer.ageCompare());
		System.out.println(roster);

		
	}
	
	
	
}
