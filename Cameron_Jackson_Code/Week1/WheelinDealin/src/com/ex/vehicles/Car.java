package com.ex.vehicles;

/*
 * Car Class
 * Extends from Vehicle
 */
public class Car extends Vehicle {
	
	// methods
	public Car() {
		super("2", 0);
	}

	public Car(String serialNumber_, int passengerCapacity_) {
		super(serialNumber_, passengerCapacity_);
		// TODO Auto-generated constructor stub
	}

	@Override
	String shortName() {
		return "CAR";
	}
}
