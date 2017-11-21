package com.rev.compareemployees;

public class CompareEmployees {
	
	public static void main(String[] args) {
		
		Comparer comparer = new Comparer();
		Employee e1 = new Employee(0, "Bill", "Johnson", 9.5, 20, 8.0, 8.0);
		Employee e2 = new Employee(1, "Jack", "Roberts", 8.5, 20, 8.0, 8.0);
		
		printEmployeeToConsole(e1);
		printEmployeeToConsole(e2);
		
		int result = comparer.compare(e1, e2);
		
		System.out.print("\nRecommendation for promotion: ");
		if (result == 0) { System.out.println(e1.getFirstName() + " " + e1.getLastName()); }
		if (result == 1) { System.out.println(e2.getFirstName() + " " + e2.getLastName()); }
		
	}
	
	static void printEmployeeToConsole(Employee e) {
	
		System.out.println("Employee id: " + e.getEmployeeId());
		System.out.println("First name: " + e.getFirstName());
		System.out.println("Last name: " + e.getLastName());
		System.out.println("Hours missed: " + e.getHoursMissed());
		System.out.println("Overtime hours: " + e.getOvertimeWorked());
		System.out.println("Peer rating: " + e.getPeerRating());
		System.out.println("Management rating: " + e.getManagementRating() + "\n");
		
	}

}
