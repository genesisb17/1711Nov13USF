package hw.q7;

public class Employee {
	public String name;
	public String department;
	public int age;
	
	public static float exampleFloat = 5;
	public static float exampleFloat2 = 8;
	
	@Override
	public String toString() {
		return "name=" + name + ", department=" + department
				+ ", age=" + age;
	}

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
}
