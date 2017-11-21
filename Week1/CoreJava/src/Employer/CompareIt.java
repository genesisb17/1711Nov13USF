package Employer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareIt{
	/* this program shows an example on how to implement the comparator 
	 * interface to help with sorting of objects based on their fields.
	 * In order to be able to use the comparator interface, you must first
	 * create an object of your own, and when placing the implement clause
	 * you must indiciate what Object will be used to implement the comparator.
	 * In this case, we are using the Employee object, which was created in the
	 * People.java file. 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> workers = new ArrayList<>();
		workers.add(new Employee("John Doe","Science",31));
		workers.add(new Employee("Candice Parker", "Technology", 21));
		
		System.out.println("Unsorted List");
		for(Employee x: workers) {
			System.out.println(x.getName() + " " + x.getDepartment() + " " + x.getAge());
		}
		
		System.out.println();
		Collections.sort(workers, new CompareByAge());
		
		System.out.println();
		System.out.println("Sorted list by age: ");
		
		for(Employee x: workers) {
			System.out.println(x.getName() + " " + x.getDepartment() + " " + x.getAge());
		}
		
		System.out.println();
		System.out.println("Sorted list by name: ");
		
		Collections.sort(workers, new CompareByName());
		
		for(Employee x: workers) {
			System.out.println(x.getName() + " " + x.getDepartment() + " " + x.getAge());
		}
		
		System.out.println();
		System.out.println("Sorted by department: ");
		
		Collections.sort(workers, new CompareByDepartment());
		
		for(Employee x: workers) {
			System.out.println(x.getName() + " " + x.getDepartment() + " " + x.getAge());
		}
		
		
		
		
		
		
		
	}
		
		
		
	}

