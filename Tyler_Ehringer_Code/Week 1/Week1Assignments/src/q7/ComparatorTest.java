package q7;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {
	
	static class Employee{
		String name, department;
		int age;
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		public String toString() {
			return "Employee name: " + name + " department: " + department + " age: " + age;
		}
	}
	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Bob", "HR", 55));
		list.add(new Employee("Joe", "VP", 38));
		list.sort((e1, e2) -> e1.age - e2.age); //use comparator via lambda
		System.out.println(list.toString());
	}

}
