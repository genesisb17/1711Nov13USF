package com.q7;

import java.util.Comparator;

public class Employee {
	
		//fields
		String name;
		String department;
		int age;
		
		//Constructor (only one)
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		//Rules for printing
		public String toString() {
			return this.name + " | " + this.department + " | " + this.age;
		}
		
		
		//Inner class
		//made static (instances won't do the comparing, it is a function of the class
		static class Comparer{
			
			//since strings implement Comparator, their built in comparison is used
			static class nameCompare implements Comparator<Employee>{
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.name.compareToIgnoreCase(e2.name); 
				}
			}
			
			static class departmentCompare implements Comparator<Employee>{

				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.department.compareToIgnoreCase(e2.department);
				}
				
			}
			
			//since a return of a negative number means e1 is smaller, we can
			//just subtract the two values from each other to make this comparison easy
			static class ageCompare implements Comparator<Employee>{

				@Override
				public int compare(Employee e1, Employee e2) {
					
					return e1.age - e2.age;
				}
				
			}
		}

}
