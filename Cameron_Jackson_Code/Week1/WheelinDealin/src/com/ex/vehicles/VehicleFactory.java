package com.ex.vehicles;

public class VehicleFactory {
	static String BSN = "BAD SERIAL";
	public Vehicle CreateVehicle(Vehicle.VehicleInfo info) {
		Vehicle vObj;
//		System.out.println("SN: " + info.sn);
		// Check to see what the vehicleType is
		switch (info.vt) {
		case VEHICLE:
			vObj = new Vehicle(info.sn, info.pc);
			++info.unkNum;
			info.totalToll += vObj.toll();
			break;
		case CAR:
			vObj = new Car(info.sn, info.pc);
			++info.carNum;
			info.totalToll += vObj.toll();
			break;
		case TRUCK:
			vObj = new Truck(info.sn, info.pc, info.dl);
			++info.trkNum;
			info.totalToll += vObj.toll();
			break;
		case VAN:
			vObj = new Van(info.sn, info.pc, info.dl, info.length, info.width, info.height);
			++info.vanNum;
			info.tons += vObj.loadCapacity();
			info.totalToll += vObj.toll();
			break;
		case TANKER:
			vObj = new Tanker(info.sn, info.pc, info.dl, info.length, info.radius);
			++info.tnkNum;
			info.tons += vObj.loadCapacity();
			info.totalToll += vObj.toll();
			break;
		case FLATBED:
			vObj = new Flatbed(info.sn, info.pc, info.dl, info.length, info.width);
			++info.fltNum;
			info.tons += vObj.loadCapacity();
			info.totalToll += vObj.toll();
			break;
		default:
			vObj = new Vehicle(BSN, 0);
			++info.badSNum;
		}
		return vObj;
	}
}
