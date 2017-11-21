package com.rev.compareemployees;

import java.util.Comparator;

public class Comparer implements Comparator<Employee>{
	
	@Override
	public int compare(Employee e1, Employee e2) {
		
		double e1_overallRating = e1.getManagementRating() + e1.getPeerRating() + e1.getOvertimeWorked() - e1.getHoursMissed();
		double e2_overallRating = e2.getManagementRating() + e2.getPeerRating() + e2.getOvertimeWorked() - e2.getHoursMissed();
		
		if (e1_overallRating > e2_overallRating) {
			return 0;
		}
		
		else if (e1_overallRating < e2_overallRating) {
			return 1;
		}
		
		else {
			if (e1.getEmployeeId() < e2.getEmployeeId()) {
				return 0;
			}
			
			else {
				return 1;
			}
		}
		
		

	}

}
