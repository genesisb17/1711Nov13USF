package com.rev.compareemployees;

public class Employee {
	
	int employeeId;
	String firstName;
	String lastName;
	double hoursMissed;
	double overtimeWorked;
	double peerRating;
	double managementRating;
	
	/**
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param hoursMissed
	 * @param overtimeWorked
	 * @param peerRating
	 * @param managementRating
	 */
	public Employee(int employeeId, String firstName, String lastName, double hoursMissed, double overtimeWorked,
			double peerRating, double managementRating) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursMissed = hoursMissed;
		this.overtimeWorked = overtimeWorked;
		this.peerRating = peerRating;
		this.managementRating = managementRating;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the hoursMissed
	 */
	public double getHoursMissed() {
		return hoursMissed;
	}

	/**
	 * @param hoursMissed the hoursMissed to set
	 */
	public void setHoursMissed(double hoursMissed) {
		this.hoursMissed = hoursMissed;
	}

	/**
	 * @return the overtimeWorked
	 */
	public double getOvertimeWorked() {
		return overtimeWorked;
	}

	/**
	 * @param overtimeWorked the overtimeWorked to set
	 */
	public void setOvertimeWorked(double overtimeWorked) {
		this.overtimeWorked = overtimeWorked;
	}

	/**
	 * @return the peerRating
	 */
	public double getPeerRating() {
		return peerRating;
	}

	/**
	 * @param peerRating the peerRating to set
	 */
	public void setPeerRating(double peerRating) {
		this.peerRating = peerRating;
	}

	/**
	 * @return the managementRating
	 */
	public double getManagementRating() {
		return managementRating;
	}

	/**
	 * @param managementRating the managementRating to set
	 */
	public void setManagementRating(double managementRating) {
		this.managementRating = managementRating;
	}
	
	
	
}
