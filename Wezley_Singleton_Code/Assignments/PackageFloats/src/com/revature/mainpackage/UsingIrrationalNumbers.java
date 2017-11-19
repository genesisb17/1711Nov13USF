package com.revature.mainpackage;

import static com.revature.packagefloats.IrrationalNumberConstants.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsingIrrationalNumbers {

	public static void main(String[] args) {

		calculateVolumeOfSphere();
		eulersFormula();

	}

	static double getDoubleFromUser() throws InputMismatchException {

		Scanner scan = new Scanner(System.in);
		
		double userInput;
		
		try {

			userInput = scan.nextDouble();
			scan.close();
			return userInput;

		}

		catch (InputMismatchException ime) {
			System.out.println("You have entered an invalid value. Please try again...\n");
			userInput = 0.0;
			throw ime;
		}

		catch (Exception e) {
			System.out.println("Something went wrong...\n");
			e.printStackTrace();
			return 0.0;
		}

	}

	static void calculateVolumeOfSphere() {

		System.out.print("Calculate the volume of a sphere!\nEnter the radius of the sphere: ");

		try {
			double userInput = 0.0;
			userInput = getDoubleFromUser();
			
			double volume;
			double radius = userInput;
			double radiusCubed = radius * radius * radius;
			//double circumference = 2 * PI * radius;

			volume = (4/3) * PI * (radiusCubed);

			System.out.printf("The volume of a sphere with a radius of %.4f is: %.4f cubic units.", radius, volume);
		}
		
		catch (InputMismatchException ime) {
			calculateVolumeOfSphere();
		}

	}
	
	static void eulersFormula() {
		
		System.out.println("\n\nEuler's formula states that 'e' raised to the power of pi times the imaginary "
				+ "number 'i', is equal to -1.\n\n+-------------Approx. Values-------------+\n\ne = "
				+ E + "\npi = " + PI + "\ni = square root of -1\n\n");
		
		double result;
		
		// doesn't return a value, because Math.sqrt() cannot handle negative numbers (creates imaginary numbers)
		result = Math.pow(E, (PI * Math.sqrt(I_SQUARED)));
		
		System.out.print("e ^ (pi * i) = ");
		
		// The standard Java library doesn't play nicely with imaginary numbers like i (square root of -1).
		if (Double.toString(result) == "NaN") {
			System.out.println("-1");
		}
		
	}
	
}

