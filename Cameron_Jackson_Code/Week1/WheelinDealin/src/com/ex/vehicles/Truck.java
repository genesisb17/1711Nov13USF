package com.ex.vehicles;

public class Truck extends Vehicle {

	// instances
	String DOTLicense_;
	
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
	
	String DOTLicense() {
		return this.DOTLicense_;
	}
	
}
