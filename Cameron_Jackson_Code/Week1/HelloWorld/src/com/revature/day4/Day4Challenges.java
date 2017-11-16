package com.revature.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.revature.io.Student;

public class Day4Challenges {

	static String filename = "src/logs/Data.txt";
	public static void main(String[] args) {
		// create arraylist
		CreateArrayList(); 
		
		// Find minimum of numbers
		System.out.println("Enter two numbers separated by space: ");
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[2];
		String input = scan.nextLine();
		String[] inarr = input.split(" ");
		for (int i = 0; i < 2; ++i) {
			nums[i] = Integer.parseInt(inarr[i]);
		}
		System.out.println("Minimum: " + Minimum(nums[0], nums[1]));
		
		// Demonstrate Switch
		DoStuff();
		
		// Get data from file
		// expanded Student Class
		ArrayList<Student> people = readStudents();
		for (Student person: people) {
			person.formattedPrint();
		}
		scan.close();
	}

	/*
	 * Function to determine if number is even
	 * Mask with 1. Leftmost bit will be set if odd
	 */
	public static boolean IsEven(int num) {
		if ((num & 1) == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * creates arraylist of integers from 1-100
	 */
	public static void CreateArrayList() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 100; ++i) {
			nums.add(i);
		}
		System.out.println("Printing arraylist: ");
		PrintArrayList(nums);
	}
	
	/*
	 * prints arraylist of integers
	 */
	public static void PrintArrayList(ArrayList<Integer> nums) {
		for (int i : nums) {
			System.out.println(i);
		}
	}
	
	/* 
	 * finds the minimum of two numbers
	 */
	public static int Minimum(int n1, int n2) {
		return (n1 < n2) ? n1 : n2;
	}
	
	/*
	 * Demonstrate Switch Case
	 */
	public static void DoStuff() {
		int input;
		do {
			System.out.println("Enter a number 1-3. Enter 0 to exit: ");
			Scanner scan = new Scanner(System.in);
			input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter number to find root of: ");
				int root = scan.nextInt();
				System.out.println("Square root: " + Math.sqrt(root));
				break;
			case 2:
				Calendar today = Calendar.getInstance();
				System.out.println("Date: " + today.getTime());
				break;
			case 3:
				String str = "I am learning Core Java";
				String[] str_arr = str.split(" ");
				break;
			}
		} while (input != 0);
		System.out.println("Goodbye.\n");
	}
	
	/*
	 * File I/o
	 */
	static ArrayList<Student> readStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try (BufferedReader br = 
				new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] member = line.split(":");
				Student temp = new Student();
				temp.setName(member[0], member[1]);
				temp.setAge(Integer.parseInt(member[2]));
				temp.setState(member[3]);
				students.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}
}
