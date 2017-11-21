package com.revature.corejavahw;

import java.util.Collections;
import java.util.LinkedList;

public class Problem7 {
	static class Employees {
		private String name;
		private String dep;
		private int age;
		
		public Employees() {}
		
		public Employees(String name, String dep, int age) {
			this.name = name;
			this.dep = dep;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDep() {
			return dep;
		}

		public void setDep(String dep) {
			this.dep = dep;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employees [name=" + name + ", dep=" + dep + ", age=" + age + "]";
		}	
		
	}
	
	public static void main(String[] args) {
		Employees employee1 = new Employees("Billy Bob", "Electronics", 32);
		Employees employee2 = new Employees("Sara Sue", "Garden", 23);
		LinkedList<Employees> employeeList = new LinkedList<Employees>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		/* Sort based on Age */
//		Collections.sort(employeeList, (e1, e2) -> e1.getAge() - e2.getAge());
		/* Sort based on Name */
//		Collections.sort(employeeList, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		/* Sort based on Department */
		Collections.sort(employeeList, (e1, e2) -> e1.getDep().compareTo(e2.getDep()));
		for (Employees e : employeeList) {
			System.out.println(e); 
		}
	}
	
}


