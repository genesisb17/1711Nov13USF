package com.ex.vehicles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	static String filename = "src/logs/segment1.txt";
	public static void main(String[] args) {
		VehicleInfo info = new VehicleInfo();
		
		// anonymous method to read number of cars in segment
		info.vps = Integer.parseInt(SafeRead());
		while ((info.vps > 0) && (info.vps < maxSegmentSize)) {
			for (int i = 0; i < info.vps; ++i) { 
				// Decode serial number
				String[] temp = SafeRead().split(" ");
				info.sn = temp[0]; // first element is serial number
				info.vt = Vehicle.SnDecode(info.sn); 
				
				// If other data is needed, read that data
				info.pc = Integer.parseInt(temp[1]); // second element is passenger cap
				if (info.vps > 2) info.dl = temp[2]; // DOTLicense 
				switch (info.vt) { // Vehicle, Car, and Truck have no additional values
				case VAN:
					info.length = Integer.parseInt(temp[3]);
					info.width = Integer.parseInt(temp[4]);
					info.height = Integer.parseInt(temp[5]);
					break;
				case TANKER:
					info.length = Integer.parseInt(temp[3]);
					info.radius = Integer.parseInt(temp[4]);
					break;
				case FLATBED:
					info.length = Integer.parseInt(temp[3]);
					info.width = Integer.parseInt(temp[4]);
					break;
				default:	
				}
				// Create a vehicle of the appropriate type using the data read in the previous steps
				// Update various summary information for this segment
			}			
		} 
	}

	static String SafeRead() {
		try (BufferedReader br = 
				new BufferedReader(new FileReader(filename))) {
			return br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "NULL";
	}
	
//	static Vehicle CreateVehicle(Vehicle[] vArray, VehicleInfo info) {
//		
//	}

}
