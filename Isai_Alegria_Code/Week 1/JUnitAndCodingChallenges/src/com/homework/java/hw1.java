package com.homework.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import lab.Student;

public class hw1 {
	
	static String filename = "src/logs/Data.txt";
	
	public static void main(String[] args) {
		
		Student s1 = new Student("Mickey", "Mouse", 35, "Arizona");
		Student s2 = new Student("Hulk", "Hogan", 50, "Virginia");
		Student s3 = new Student("Roger", "Rabbit", 18, "California");
		Student s4 = new Student("Wonder", "Woman", 22, "Montana");
		writeStudent(s1);
		writeStudent(s2);
		writeStudent(s3);
		writeStudent(s4);
		
		ArrayList<Student> studs = new ArrayList<Student>();
		studs = readStudents();
		System.out.println(studs);
		
		//call bubblesort on int array and print it
		System.out.println("Calling bubblesort on intArray.");
		int[] intArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		bubbleSort(intArray);
		int len = Array.getLength(intArray);
		for(int i =0; i < len; i++) {
			System.out.println(intArray[i]);	
		}
		
		//calling fibonacci function
		fibonacci();	
		
		//initialize string and call the reverse string function
		String str = "string";
		reverse(str);
		
		//initialize number and call function to find factorial
		int num = 8;
		int num2 = 0;
		num2 = factorial(8);
		System.out.println("Factorial of " + num + " is: " + num2);
		
		//call function that returns the substring of a given string and index
		int index = 4;
		System.out.println(subString(str,index));
		
		//call function to determine whether or not an integer is even or odd
		evenOrOdd(index);
		
		employee emp1 = new employee("Isai","Alegria",24,"Engineering");
		employee emp2 = new employee("James","Bond",40,"Espionage");
		
		arrayListFunction();
		primeNums();
		min(10,5);
		printEvenNums();
		printTriangle();
		
		System.out.println(MathStuff.addition(4,5));
		System.out.println(MathStuff.subtraction(10, 5));
		System.out.println(MathStuff.multiplicaiton(10, 2));
		System.out.println(MathStuff.division(10,2));
		
		String[] blah = new String[10];
		blah[0] = "testing";
		stringLength(blah);
		
	}

	
	

	static void bubbleSort(int[] inputArray) {
		/* the bubble sort method basically checks the first two elements
		 * compares them to each other, and sorts them accordingly, 
		 * placing the one with lower value to the left and higher
		 * value to the right
		 * 
		 */
		int size = inputArray.length;
		for(int x = 0; x< size-1; x++)
			for(int y = 0; y< size - x - 1; y++) {
				if(inputArray[y] > inputArray[y + 1]) {
					int temp = inputArray[y];
					inputArray[y] = inputArray[y+1];
					inputArray[y+1]= temp;
				}
			}
		
	}
	
	static void fibonacci() {
		/*
		 * function to display the first 25 number of the fibonacci sequence
		 */
		
		 int i = 1, n = 25, t1 = 0, t2 = 1;
	        System.out.print("First " + n + " terms:\n");

	        while (i <= n)
	        {
	            System.out.print(t1 + "\n");

	            int sum = t1 + t2;
	            t1 = t2;
	            t2 = sum;

	            i++;
	        }
		
	}
	
	static void reverse(String s) {
		
		/*
		 * function to reverse a given string without using a temporary
		 * variable or reverse function in StringBuilder and StringBuffer
		 * API's. Turns string into a char array then using a separate array
		 * to switch spelling of string.
		 */
		
		System.out.println("going to reverse :" + s);
		
		char [] charArr = s.toCharArray();
		int len = charArr.length;
		int len2 = len;
		char[] tempArr = new char[len];
		
		for(int i =0;i<len;i++) {
			
			tempArr[len2-1] = charArr[i];
			len2--;
		}
		
		System.out.print("reversed is: ");
		System.out.println(tempArr);
	}

	static String reverseString(String s) {
		
		/*
		 * function to reverse a given string without using a temporary
		 * variable or reverse function in StringBuilder and StringBuffer
		 * API's. Turns string into a char array then using a separate array
		 * to switch spelling of string.
		 */
				
		char [] charArr = s.toCharArray();
		int len = charArr.length;
		int len2 = len;
		char[] tempArr = new char[len];
		
		for(int i =0;i<len;i++) {
			
			tempArr[len2-1] = charArr[i];
			len2--;
		}
		
		//System.out.println(tempArr);
		
		String ret;
		ret = String.valueOf(tempArr);
		
		return ret;
	}
	
	public static int factorial(int n) {
		
		//int value;
		
		if(n<0) {
			
			System.out.println("can't be a negative number");
		}
		
		if(n==0)
			return 1;
	
		
		return (n * factorial(n-1));
		
	}
	
	public static String subString(String str, int index) {
		
		String retStr = null;
		char[] charArr = str.toCharArray();
		int len = charArr.length;
		char[] tempArr = new char[len];
		
		for(int i = 0; i < index; i++) {
			
			tempArr[i] = charArr[i];
			
		}
		
		retStr = String.valueOf(tempArr);
		
		return retStr;
	}
	
	
	//function that returns true if integer passed in is even
	//returns false is it is odd
	//uses & operator as opposed to the modulus operator
	public static void evenOrOdd(int val) {
		
		if((val & 1) == 0) {
			System.out.println("The number entered is even.");
		}
		
		else
		{
			System.out.println("The number entered is odd.");
		}
	}
	
	public static void arrayListFunction() {
		
		  ArrayList<String> list=new ArrayList<String>();
		  ArrayList<String> list2=new ArrayList<String>();

		  list.add("karan");
		  list.add("madam");
		  list.add("tom");
		  list.add("jimmy");
		  list.add("civic");
		  list.add("radar");
		  list.add("sexes");
		  list.add("kayak");
		  list.add("john");
		  list.add("refer");
		  list.add("did");
		  list.add("billy");
		  
		  
		  while(list.isEmpty()!= true) {
			  
			  String temp, temp2 = null;
			  temp = list.get(0);
			  temp2 = reverseString(temp);
			  if(temp.equals(temp2))
				  list2.add(temp);
			  
			  list.remove(0);
		  }
		  
		  System.out.println(list2);
		  
		  
		  
	}
	
	
	public static void primeNums() {
		
		ArrayList<Integer> intList = new ArrayList<>();
		Integer temp;
		int x;
		boolean isPrime = true;
		
		for(int i=1; i < 101; i++) {
			intList.add(i);
		}
		
		while(intList.isEmpty()!=true)
		{
			
			isPrime = true;
			temp = intList.get(0);
			for(int i=2;i<=temp/2;i++)
			{
		           x=temp%i;
			   if(x==0)
			   {
			      isPrime=false;
			      break;
			   }
			}
			//If isPrime is true then the number is prime 
			if(isPrime)
			{
				
			   System.out.println(temp + " is a Prime Number");
			}	  

			  intList.remove(0);	  
				  
		 }
			  
			  
		} //primeNums end
	
	//find the smaller value of two numbers using ternary operator
	public static void min(int x, int y) {
		
		
		int value;
		value = (x < y) ? x : y;
		
		System.out.println(value + " is the smaller number");


	}
	
	public static void printEvenNums() {
	
		int[] intArray = new int[101];
		for(int i = 0; i <101; i++)
		{
			intArray[i] = i;
		}
		
		System.out.println("printing even numbers from 0 to 100, real quick");
		for(int iterator: intArray) {
			
			if(iterator%2 == 0) {
				System.out.println(iterator);	
			}
			
			}
	
	}
	
	public static void printTriangle() {
		
		System.out.println("printing triangle:");
		 for (int i=0; i<4; i++)
		  {
			 if(i==0)
				 System.out.println("0");
			 if(i==1)
				 System.out.println("1 0");
			 if(i==2)
				 System.out.println("1 0 1");
			 if(i==3)
				 System.out.println("0 1 0 1");
		  }
		
		
	}
	
	public static void switchFunction() {
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter number: ");
		int number = scan.nextInt();
		scan.close();
		
		switch(number) {
		
		case 1:
			int square = 25;
			System.out.println("Square root of " + square + " is " + Math.sqrt(square));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3:
			String str = "I am learning Java";
			String[] arr = str.split(" ");
			break;
			
		}
	}
	
	public static void stringLength(String[] args) {
		
		int count= 0;
		String temp = args[0];
		int len = temp.length(); 
		
		
		for(int i =0; i <len; i++) {
			count++;
		}
		
		System.out.println("Length of string entered is " + count);
	}
	
	public static int calculateInterest() {
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter principal: ");
		int principal = scan.nextInt();
		
		System.out.println("Enter interest: ");
		int interest = scan.nextInt();
		
		System.out.println("Enter interest (in years): ");
		int time = scan.nextInt();
				
		return principal*interest*time;
	}
	
	public static void q19Function() {
		
		ArrayList<Integer> arl = new ArrayList<Integer>();
		for(int i = 1; i <11; i++) {
			arl.add(i);
		}
		
		System.out.println(arl);
		int total = 0;
		for(Integer num:arl) {
			if(num %2 ==0)
				total = total + num;
		}
		System.out.println("addition of even numbers is " + total);
		
		int x;
		int temp = 0;
		boolean isPrime = true;
		
		for(int i = 0; i<arl.size(); i++)
		{

			temp = arl.get(i);
			for(int j=2;j<=temp/2;i++)
			{
		           x=temp%j;
			   if(x==0)
			   {
			      isPrime=false;
			      break;
			   }
			}
			//If isPrime is true then the number is prime 
			if(isPrime)
			{
				arl.remove(i);
			}	  
				  
		 }
		
		System.out.println("Arraylist wihtout prime numbers is " + arl);
			
	}
	
	
	static void writeStudent(Student student) {
		
		//Try-with-resource
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write(student.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}

	static ArrayList<Student> readStudents() {
		
		ArrayList<Student> students = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = null;
			while((line = br.readLine())!=null) {
				String[] about = line.split(":");
				Student temp = new Student();
				temp.setfName(about[0]);
				temp.setlName(about[1]);
				temp.setAge(Integer.parseInt(about[2]));
				temp.setLocation(about[3]);
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
