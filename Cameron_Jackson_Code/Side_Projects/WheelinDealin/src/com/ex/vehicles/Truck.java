package com.ex.vehicles;

/*
 * Truck Class
 * Extends from Vehicle
 */
public class Truck extends Vehicle {

	// instances
	private String DOTLicense_;
	
	// methods
	public Truck() {
		super("3", 0);
	}

	public Truck(String serialNumber_, int passengerCapacity_, String DOTLicense_) {
		super(serialNumber_, passengerCapacity_);
		this.DOTLicense_ = DOTLicense_;
	}

	@Override
	String shortName() {
		return "TRK";
	}

	double toll() {
		return 10.00; // toll for trucks
	}
	
	public String DOTLicense() {
		return this.DOTLicense_;
	}
	
}
