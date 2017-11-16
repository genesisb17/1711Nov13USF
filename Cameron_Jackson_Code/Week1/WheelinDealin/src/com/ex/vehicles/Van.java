package com.ex.vehicles;

public class Van extends Vehicle {

//	  float         LoadCapacity       () const  // returns volume of box  
//	  const char*   ShortName          () const  // returns "VAN"
	
	public Van() {
		super("4", 0);
	}

	public Van(String serialNumber_, int passengerCapacity_) {
		super(serialNumber_, passengerCapacity_);
	}

//	double loadCapacity() {
//		return this.box()
//	}
//	
//	private class Box() {
//		
//	}
}
