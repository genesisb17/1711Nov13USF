package com.ex.vehicles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * A class to emulate the Florida Dept. of Transportation's
 * Sunpass Tracker.
 * project idea taken from:
 * https://www.cs.fsu.edu/~lacher/courses/COP3330/spring15/assigns/proj1.html
 * 
 * Demonstrates polymorphism by creating objects of various different vehicle types
 * at runtime and managing them with a single main Vehicle typed array.
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
	
	static int maxSegmentSize = 100;
	static String BSN = "BAD SERIAL";
	
	static String filename = "src/logs/segment2.txt";
	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Vehicle[] vehicleArray;
		VehicleInfo info = VehicleInfo.getInstance();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		// anonymous method to read number of cars in segment
		ArrayList<String[]> temp = SafeRead(br);
		
		System.out.println("Tracking started...");
		// I don't like this data structure:
		// ArrayList temp at index 0 is an array of strings which must also be indexed
		//   temp elements are an entire line from file
		//   temp[index] elements are each word in that line
		int lineNum = 0;
		info.vps = Integer.parseInt(temp.get(lineNum)[0]); // first line
		++lineNum; // lineNum moves to next line
		// System.out.println(info.vps);
		vehicleArray = new Vehicle[info.vps]; // an array of vehicle objects
		while ((info.vps > 0) && (info.vps < maxSegmentSize)) {
			int offSet = lineNum;
			// loops through segment
			for (int i = 0+lineNum; i < (info.vps+offSet); ++i) { // loops through each vehicle
				// Decode serial number
				info.sn = temp.get(i)[0]; // first element is serial number
				info.vt = Vehicle.SnDecode(info.sn); 
				
				// If other data is needed, read that data
//				System.out.println("vps + offSet: " + (info.vps+offSet));
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
//				System.out.println("i - offSet: " + (i-offSet));
//				System.out.println("VehicleArray size: " + vehicleArray.length);
				CreateVehicle(vehicleArray, info, i-offSet);
				
				// increase lineNum
				++lineNum; // should be the same is i
			} // END FOR
			// Print summary
			Summary(vehicleArray, info);
			
			// Reset info structure
			info.resetFields();
//			System.out.println("linenum: " + lineNum);
//			System.out.println("line: " + temp.get(lineNum)[0]);
			info.vps = Integer.parseInt(temp.get(lineNum)[0]); // For loop doesn't include lines after last vehicle
//			System.out.println("vps: " + info.vps);
			vehicleArray = new Vehicle[info.vps]; // Start new Array

			++lineNum;
		} // END WHILE
		System.out.println("Tracking Complete.");
	}
	// END MAIN METHOD

	static ArrayList<String[]> SafeRead(BufferedReader br) throws IOException {
		String line = null;
		ArrayList<String[]> dataArray = new ArrayList<String[]>(); // a list of string arrays
		try {
			while ((line = br.readLine()) != null) {
				if (line.trim().length() > 0) dataArray.add(line.split("\\s+")); // if line was skipped ignore
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		
//		for (int i = 0; i < dataArray.size(); ++i) {
//			for (int j = 0; j < dataArray.get(i).length; ++j) {
//				System.out.print(dataArray.get(i)[j] + " ");
//			}
//			System.out.println("");
//		}
		return dataArray;
	}
	
	static void CreateVehicle(Vehicle[] vArr, VehicleInfo info, int index) {
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
		vArr[index] = vObj;
	}

	public static void Summary(Vehicle[] vArr, VehicleInfo info) {
		DecimalFormat df = new DecimalFormat(".##");
		System.out.println("Segment Summary");
		System.out.println("===============");
		
		// Car total
		System.out.println("Cars: " + info.carNum);
		// Truck total
		System.out.println("Trucks: " + info.trkNum);
		// Van total
		System.out.println("Vans: " + info.vanNum);
		// Tanker total
		System.out.println("Tankers: " + info.tnkNum);
		// Flatbed total
		System.out.println("Flatbeds: " + info.fltNum);
		// Unknown total
		System.out.println("Unknown: " + info.unkNum);
		// BadSN total
		System.out.println("BadSN: " + info.badSNum);
		// Tonnage
		System.out.println("Tonnage: " + df.format(info.tons));
		// Total Tolls
		System.out.println("Tolls: " + df.format(info.totalToll) + "\n");
		
		System.out.println("Segment Details");
		System.out.println("===============");
		for (int i = 0; i < vArr.length; ++i) {
			System.out.print(vArr[i].shortName() + "  " +
					df.format(vArr[i].toll()) + "  " + vArr[i].passengerCapacity() + 
					df.format(vArr[i].loadCapacity()) + "  ");
			switch (Vehicle.SnDecode(vArr[i].serialNumber())) {
			case BADSN:
			case VEHICLE:
			case CAR:
				System.out.print("(N/A)  ");
				break;
			case FLATBED:
				System.out.print(((Flatbed)vArr[i]).DOTLicense() + "  ");
				break;
			case TANKER:
				System.out.print(((Tanker)vArr[i]).DOTLicense() + "  ");
				break;
			case TRUCK:
				System.out.print(((Truck)vArr[i]).DOTLicense() + "  ");
				break;
			case VAN:
				System.out.print(((Van)vArr[i]).DOTLicense() + "  ");
				break;
			default:
				break;
			} // END SWITCH
			System.out.print(vArr[i].serialNumber() + "\n");
		} // END FOR
		
	}
}
