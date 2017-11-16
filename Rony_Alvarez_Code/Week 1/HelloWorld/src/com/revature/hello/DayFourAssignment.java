package com.revature.hello;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.revature.io.User;

public class DayFourAssignment {

	public static void main(String[] args) {
		
		//int number = 4;
		//System.out.println(isEven(number));
		
		//System.out.println(minumun(34, 2));
		//System.out.println(primeNumbers());
		readFile();
		

	}
	
	public static boolean isEven(double num) {
		
		if((num % 2 == 0)) {
			return true;
		}
		
		return false;
		
	}
	
	public static ArrayList<Integer> primeNumbers() {

		//ArrayList<Integer> nums = new ArrayList<Integer>();
		//nums = (ArrayList<Integer>) IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());

		ArrayList<Integer> list = new ArrayList<Integer>();

		// loop through the numbers one by one
		for (int n = 1; n < 100; n++) {
			boolean prime = true;
			// analyzes if n is prime

			for (int j = 2; j < n; j++) {
				if (n % j == 0) {
					prime = false;
					break; // exit the inner for loop
				}
			}
			if (prime && n != 1) {
				list.add(n);
			}
		}

		return list;

	}
	
	public static int minumun(int first, int second) {
		
		int minval = first < second? first : second; 
		
		return minval;
		
	}
	
	public static void swtich(int num) {
		
		switch(num) {
			
		case 1: 
			System.out.println(Math.sqrt(45));
			break;
			
		case 2:
			java.util.Date date = new java.util.Date();
		    System.out.println(date);
			break;
			
		case 3:
			String str = "I am learning Core Java";
			String[] arr = str.split(" ");			
			break;			
			
		default: 
				System.out.println("default case");
		
		}
		
	}
	
	public static void readFile() {

		String filename = "src/logs/Data.txt";
		
		ArrayList<User> users = new ArrayList<User>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line = null;
			while ((line = br.readLine()) != null) {

				String[] about = line.split(":");
				User temp = new User();
				temp.setName(about[0]);
				temp.setPassword(about[1]);
				users.add(temp);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		System.out.println("Name: " + users.get(0).toString() + " " + users.get(1).toString());
		
	}
	
	
}
