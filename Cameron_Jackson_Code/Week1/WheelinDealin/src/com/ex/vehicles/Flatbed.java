package com.ex.vehicles;

/*
 * Flatbed Class
 * Extends from Vehicle
 * Uses Plane helper class to store and calulate
 * dimensions of vehicle
 */
public class Flatbed extends Vehicle {
	
	class Plane {
		private int length;
		private int width;
		
		private Plane() {}
		private Plane(int l, int w) {
			this.length = l;
			this.width = w;
		}
		
		double Area() {
			return this.length*this.width;
		}
	}
	
	private Plane plane;
	
	public Flatbed() {
		super("6", 0);
		plane = new Plane(0,0);
	}

	public Flatbed(String serialNumber_, int passengerCapacity_, int l, int w) {
		super(serialNumber_, passengerCapacity_);
		plane = new Plane(l, w);
	}
	
	double loadCapacity () {
		return this.plane.Area();
	}
	
	String shortName() {
		return "FLT";
	}
}
