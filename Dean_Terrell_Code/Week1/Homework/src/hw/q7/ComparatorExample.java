package hw.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {
		ArrayList<Employee> ae = new ArrayList<Employee>();
		
		ae.add(new Employee("Dave", "Finance", 28));
		ae.add(new Employee("Jessica", "Business", 23));
		ae.add(new Employee("Aaron", "Sales", 20));
		
		System.out.println("Original list: ");
		for(Employee e : ae)
			System.out.println(e);
		
		Comparator<Employee> byName = (Employee o1, Employee o2) -> o1.name.compareTo(o2.name);
		Comparator<Employee> byAge = (Employee o1, Employee o2) -> o1.age-(o2.age);
		Comparator<Employee> byDepartment = (Employee o1, Employee o2) -> o1.department.compareTo(o2.department);

		System.out.println("\nBy name:");
		Collections.sort(ae, byName);
		for(Employee e : ae)
			System.out.println(e);
		
		System.out.println("\nBy age:");
		Collections.sort(ae, byAge);
		for(Employee e : ae)
			System.out.println(e);
		
		System.out.println("\nBy department:");
		Collections.sort(ae, byDepartment);
		for(Employee e : ae)
			System.out.println(e);
	}

}
