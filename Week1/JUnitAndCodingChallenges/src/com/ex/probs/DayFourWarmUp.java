package com.ex.probs;

import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DayFourWarmUp extends Student{
	static String fileName = "src/logs/data.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 4/2;
		//System.out.println(x);
	
		
		/*
		 * Create an array list and for loop that will add numbers
		 * 1-100 to the list then run the primeChecker function to
		 * determine if number is prime or not.
		 */
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0; i<101; i++) {
			numbers.add(i);
		}
		
		for(int i=0; i<101; i++) {
			boolean result = primeChecker(numbers.get(i));
			if(result)
				System.out.println(numbers.get(i));
		}
		
		/*
		 * Example of using the switch case statements
		 */
		switch(x) {
			case 2:
				double squareRoot = Math.sqrt(36);
				System.out.println("The Square Root of 36 is: " + squareRoot);
				break;
			case 4: 
				System.out.println("Today is: Thursday, November 16th, 2017" );
				break;
			case 6:
				String tester = "I am learning Core java";
				String[] arrayOfStrings = tester.split(" ");
				break;
		}
		
		
		/*
		 * using the ternary operator to assign the value of the lowest
		 * number to a third integer
		 */
		
		int min = (31 < 94)? 31: 94;
		System.out.println("The number with smallest value between 31 and 94 is: " + min);
				
	

		
		
		//System.out.println(numbers);
		
		People mickey = new People("Mickey", "Mouse", 35, "Arizona");
		People hulk = new People("Hulk", "Hogan", 50, "Virgina");
		People roger = new People("Roger", "Rabbit", 22, "California");
		People wonder = new People("Wonder", "Woman", 18, "Montana");
		writePeople(mickey);
		writePeople(hulk);
		writePeople(roger);
		writePeople(wonder);
		
		ArrayList<People> peeps = new ArrayList<People>();
		peeps = readPeople();
		
		
	}
	static void writePeople(People people) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));){
			bw.write(people.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<People> readPeople() {
		ArrayList<People> people = new ArrayList<People>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while((line=br.readLine()) != null) {
				String[] about = line.split(":");
				People temp = new People();
				temp.setFirstName(about[0]);
				temp.setLastName(about[1]);
				System.out.println("Name: " + temp.getFirstName() + " " + temp.getLastName());
				temp.setAge(Integer.parseInt(about[2]));
				System.out.println("Age: " + temp.getAge());
				temp.setState(about[3]);
				System.out.println("State: " + temp.getState());
				System.out.println();
				people.add(temp);
			}
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
			
		}
		
		return people;
	}

	public static boolean primeChecker(int x) {
		if (x == 4) {
			return false;
		}
		
		for(int i=2; i*2<x; i++) {
			if(x%i==0)
				return false;
		}
		return true; 
	}
	
	
	public boolean evenChecker(int x) {
		/* check to see if a number is even without using 
		 * modulo
		 */
		if((x/2)+(x/2) == x) {
			System.out.println("The given number is even");
			return true;
		}
		else {
			System.out.println("The given number is odd");
			return false;
		}
	}

}
