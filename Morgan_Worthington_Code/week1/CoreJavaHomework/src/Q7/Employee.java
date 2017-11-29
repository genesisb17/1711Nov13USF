package Q7;

import java.util.Comparator;

public class Employee {
	private String name;
	private String department;
	private int age;
	

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	static class sortByName implements Comparator<Employee>{
		public int compare(Employee e1,Employee e2){
			return e1.getName().compareTo(e2.getName());
		}
	}
	
	static class sortByDepartment implements Comparator<Employee>{
		public int compare(Employee e1, Employee e2) {
			return e1.getDepartment().compareTo(e2.getDepartment());
		}
	}
	
	static class sortByAge implements Comparator<Employee>{
		public int compare(Employee e1, Employee e2) {
			return e1.getAge()-e2.getAge();
		}
	}
}

