package com.ex.vehicles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * A class to emulate the Florida Dept. of Transportation's
 * Sunpass Tracker.
 * project idea taken from:
 * https://www.cs.fsu.edu/~lacher/courses/COP3330/spring15/assigns/proj1.html
 */
public class VehicleTracker {

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
	}
	
	static int maxSegmentSize = 100;
	static String BSN = "BAD SERIAL";
	
	static String filename = "src/logs/segment1.txt";
	public static void main(String[] args) throws NumberFormatException, IOException {
		Vehicle[] vehicleArray;
		VehicleInfo info = new VehicleInfo();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		// anonymous method to read number of cars in segment
		ArrayList<String[]> temp = SafeRead(br);
		
		// I don't like this data structure:
		// ArrayList temp at index 0 is an array of strings which must also be indexed
		//   temp elements are an entire line from file
		//   temp[index] elements are each word in that line
		info.vps = Integer.parseInt(temp.get(0)[0]); 
		// System.out.println(info.vps);
		vehicleArray = new Vehicle[info.vps]; // an array of vehicle objects
		while ((info.vps > 0) && (info.vps < maxSegmentSize)) {
			for (int i = 1; i <= info.vps; ++i) { // loops through each vehicle
				// Decode serial number
				info.sn = temp.get(i)[0]; // first element is serial number
				info.vt = Vehicle.SnDecode(info.sn); 
				
				// If other data is needed, read that data
				info.pc = Integer.parseInt(temp.get(i)[1]); // second element is passenger cap
				if (temp.get(i).length > 2) info.dl = temp.get(i)[2]; // DOTLicense 
				switch (info.vt) { // Vehicle, Car, and Truck have no additional values
				case VAN:
					info.length = Integer.parseInt(temp.get(i)[3]);
					info.width = Integer.parseInt(temp.get(i)[4]);
					info.height = Integer.parseInt(temp.get(i)[5]);
					break;
				case TANKER:
					info.length = Integer.parseInt(temp.get(i)[3]);
					info.radius = Integer.parseInt(temp.get(i)[4]);
					break;
				case FLATBED:
					info.length = Integer.parseInt(temp.get(i)[3]);
					info.width = Integer.parseInt(temp.get(i)[4]);
					break;
				default:
				} 
				// Create a vehicle of the appropriate type using the data read in the previous steps
				
				CreateVehicle(vehicleArray[i-1], info);
				
				// Update various summary information for this segment
			} // END FOR		
		} 
	}

	static ArrayList<String[]> SafeRead(BufferedReader br) throws IOException {
		String line = null;
		ArrayList<String[]> dataArray = new ArrayList<String[]>(); // a list of string arrays
		try {
			while ((line = br.readLine()) != null) {
				if (line != "\n") dataArray.add(line.split(" ")); // if line was skipped ignore
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return dataArray;
	}
	
	static void CreateVehicle(Vehicle vObj, VehicleInfo info) {
		System.out.println("SN: " + info.sn);
		// Check to see what the vehicleType is
		switch (info.vt) {
		case VEHICLE:
			vObj = new Vehicle(info.sn, info.pc);
			++info.unkNum;
			break;
		case CAR:
			vObj = new Car(info.sn, info.pc);
			++info.carNum;
			break;
		case TRUCK:
			vObj = new Truck(info.sn, info.pc, info.dl);
			++info.trkNum;
			break;
		case VAN:
			vObj = new Van(info.sn, info.pc, info.length, info.width, info.height);
			++info.vanNum;
			break;
		case TANKER:
			vObj = new Tanker(info.sn, info.pc, info.length, info.radius);
			++info.tnkNum;
			break;
		case FLATBED:
			vObj = new Flatbed(info.sn, info.pc, info.length, info.width);
			++info.fltNum;
			break;
		default:
			vObj = new Vehicle(BSN, 0);
			++info.badSNum;
		}
	}

}
