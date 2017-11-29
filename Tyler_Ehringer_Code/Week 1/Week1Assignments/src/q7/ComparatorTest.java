package q7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest implements Comparator{
	
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
		ComparatorTest t = new ComparatorTest();
		list.sort(t::compare); //use comparator via lambda
		System.out.println(list.toString());
	}

	@Override
	public int compare(Object o1, Object o2) {
		return ((Employee)o1).age - ((Employee)o2).age;
	}

}
