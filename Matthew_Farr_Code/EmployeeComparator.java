package com.revature.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeComparator {
    public static void main (String[] args) {
    	ArrayList<Employee> arrLst = new ArrayList<Employee>();
    	arrLst.add(new Employee("Alex Alexson", "Software", 25));
    	arrLst.add(new Employee("Bob Bobson", "HR", 36));

    	System.out.println("Unsorted List of Employees: ");
    	printEmployees(arrLst);
    	
    	Collections.sort(arrLst, new SortByName());
    	System.out.println("\nSorted By Name: ");
    	printEmployees(arrLst);
    	
    	Collections.sort(arrLst, new SortByDept());
    	System.out.println("\nSorted by Department: ");
    	printEmployees(arrLst);
    	
    	Collections.sort(arrLst, new SortByAge());
    	System.out.println("\nSorted by Age: ");
    	printEmployees(arrLst);
    }
    
    static void printEmployees(ArrayList<Employee> arrLst) {
    	for (int i=0; i<arrLst.size(); i++)
    		System.out.println(arrLst.get(i));
    }
}

class Employee {
	
	private String name;
	private String dept;
	private int age;
	
    public Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
    }
    
    public String getName() {return name;}
    public String getDept() {return dept;}
    public int getAge() {return age;}
 
    public String toString() {
        return "[" + this.name + ", " + this.dept + ", " + this.age + "]";
    }
}
 
class SortByName implements Comparator<Employee> {
    
	public int compare(Employee a, Employee b) {
        return a.getName().compareTo(b.getName());
    }
}
 
class SortByDept implements Comparator<Employee> {
    
	public int compare(Employee a, Employee b) {
        return a.getDept().compareTo(b.getDept());
    }
}

class SortByAge implements Comparator<Employee> {
    
	public int compare(Employee a, Employee b) {
        return a.getAge() - b.getAge();
    }
}
