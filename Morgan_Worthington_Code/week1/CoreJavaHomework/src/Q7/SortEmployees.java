package Q7;

import java.util.Arrays;

public class SortEmployees {
	public static void main(String[] args) {
		Employee[] emp= {new Employee("Bert","Human Resources",55),
						 new Employee("Ernie","Sales", 32),
						 new Employee("Squidward", "Engineering",30)};
		
		System.out.println("Sorted by name:");
		Arrays.sort(emp, new Employee.sortByName());
		for(int i=0;i<emp.length;i++) {
			System.out.println(emp[i].getName()+", "+emp[i].getDepartment()+", "+emp[i].getAge());
		}
		System.out.println();
		System.out.println("Sorted by department:");
		Arrays.sort(emp, new Employee.sortByDepartment());
		for(int i=0;i<emp.length;i++) {
			System.out.println(emp[i].getName()+", "+emp[i].getDepartment()+", "+emp[i].getAge());
		}
		System.out.println();
		System.out.println("Sorted by age:");
		Arrays.sort(emp, new Employee.sortByAge());
		for(int i=0;i<emp.length;i++) {
			System.out.println(emp[i].getName()+", "+emp[i].getDepartment()+", "+emp[i].getAge());
		}
	}
}
