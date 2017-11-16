package com.ex.vehicles;

public class Van extends Vehicle {

	public static class Box {
		private int length;
		private int width;
		private int height;
		
		private Box() {}
		private Box(int l, int w, int h) {
			this.length = l;
			this.width = w;
			this.height = h;
		}
		
		double Volume() {
			return length*width*height;
		}
	}
	
	// access to box object
	private Box box;
	
	public Van() {
		super("4", 0);
		this.box = new Box(0,0,0);
	}

	public Van(String serialNumber_, int passengerCapacity_, int l, int w, int h) {
		super(serialNumber_, passengerCapacity_);
		this.box = new Box(l,w,h);
	}

	double loadCapacity() {
		return this.box.Volume();
	}
	
	String shortName() {
		return "VAN";
	}
}
