package com.ex.vehicles;

/*
 * Tanker Class
 * Extends Vehicle
 * Uses Cylinder helper class to store and calculate
 * dimensions of vehicle
 */
public class Tanker extends Truck {

	class Cylinder {
		private int length;
		private int radius;
		
		private Cylinder() {}
		private Cylinder(int l, int r) {
			this.length = l;
			this.radius = r;
		}
		
		double Volume() {
			double vol = 2 * Math.PI * radius * length; 
			return vol;
		}
	}
	
	private Cylinder cylinder;
	
	public Tanker() {
		super("5", 0, null);
		cylinder = new Cylinder(0,0);
	}

	public Tanker(String serialNumber_, int passengerCapacity_, 
			String DOTLicense, int l, int r) {
		super(serialNumber_, passengerCapacity_, DOTLicense);
		cylinder = new Cylinder(l,r);
	}
	
	public double loadCapacity () {
		return this.cylinder.Volume();
	}

	public String shortName() {
		return "TNK";
	}
	
	double toll() {
		return 10.00; // toll for trucks
	}

}
