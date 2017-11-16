package com.ex.vehicles;

/*
 * Vehicle class
 * Only deals with things that don't fly
 * Also doesn't include trains
 * Project idea taken from: 
 * https://www.cs.fsu.edu/~lacher/courses/COP3330/spring15/assigns/proj1.html
 */
public abstract class Vehicle {

	// instances
	String serialNumber_;
	int passengerCapacity_;

	// methods
	public Vehicle() { 
		this.serialNumber_ = "1";
		this.passengerCapacity_ = 0;
	}
	
	public Vehicle(String serialNumber_, int passengerCapacity_) {
		this.serialNumber_ = serialNumber_;
		this.passengerCapacity_ = passengerCapacity_;
	}

	String serialNumber() {
		return this.serialNumber_;
	}
	
	int passengerCapacity() {
		return this.passengerCapacity_;
	}
	
	float loadCapacity() {
		return 0;
	}
	
	String shortName() {
		return "UNK";
	}
	
	double toll() { 
		return 2.00; // standard toll price
	}
	
	static VehicleType SnDecode(String sn) {
		switch (sn.charAt(0)) {
		case '1':
			return VehicleType.VEHICLE;
		case '2':
			return VehicleType.CAR;
		case '3':
			return VehicleType.TRUCK;
		case '4':
			return VehicleType.VAN;
		case '5':
			return VehicleType.TANKER;
		case '6':
			return VehicleType.FLATBED;
		default:
			return VehicleType.BADSN;
		}
	}
	

}
