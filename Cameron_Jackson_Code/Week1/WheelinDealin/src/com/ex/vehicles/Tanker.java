package com.ex.vehicles;

public class Tanker extends Vehicle {

	class Cylinder {
		private int length;
		private int radius;
		
		private Cylinder() {}
		private Cylinder(int l, int r) {
			this.length = l;
			this.radius = r;
		}
		
		double Volume() {
			return this.length*this.radius;
		}
	}
	
	private Cylinder cylinder;
	
	public Tanker() {
		super("5", 0);
		cylinder = new Cylinder(0,0);
	}

	public Tanker(String serialNumber_, int passengerCapacity_, int l, int r) {
		super(serialNumber_, passengerCapacity_);
		cylinder = new Cylinder(l,r);
	}
	
	public double loadCapacity () {
		return this.cylinder.Volume();
	}

	public String shortName() {
		return "TNK";
	}
}
