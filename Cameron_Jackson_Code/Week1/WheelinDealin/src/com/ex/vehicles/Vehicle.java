package com.ex.vehicles;

/*
 * Vehicle class
 * Subclasses: Car, Truck, Van, Tanker, Flatbed
 * Only deals with things that don't fly
 * Also doesn't include trains
 * Project idea taken from: 
 * https://www.cs.fsu.edu/~lacher/courses/COP3330/spring15/assigns/proj1.html
 */
public class Vehicle {

	/*
	 * VehicleInfo only holds general information pertaining
	 * to vehicles to help with object creation
	 */
	static class VehicleInfo { 
		VehicleType vt;
		int vps; // number of vehicles per segment
		int carNum, trkNum, vanNum, 
			fltNum, tnkNum, unkNum, badSNum;
		int length, width, height, radius;
		int pc; // passenger capacity
		double tons;
		double totalToll;
		String sn; // Serial Number
		String dl; // DOTLicense
		private static VehicleInfo vinfo = new VehicleInfo();
		
		private VehicleInfo() {}
		
		public static VehicleInfo getInstance() {
			return vinfo;
		}
		
		public void resetFields() {
			carNum = trkNum = vanNum = fltNum = 
					tnkNum = unkNum = badSNum = 0;
			tons = 0;
			totalToll = 0;
			
			// the following are not really necessary as the variables are just overwritten 
			// as opposed to being incremented
			vps = 0;
			length = width = height = radius = 0;
			pc = 0; 
			sn = null;
			dl = null;
		}
	}
	
	// instances
	private String serialNumber_;
	private int passengerCapacity_;

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
	
	double loadCapacity() {
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
