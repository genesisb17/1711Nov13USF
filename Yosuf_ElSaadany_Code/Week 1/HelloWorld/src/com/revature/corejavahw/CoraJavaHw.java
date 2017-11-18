package com.revature.corejavahw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.rev.corejavahw1.CoreJava2;

public class CoraJavaHw {

	public static void main(String[] args) {
		
		// Q1) Perform a bubble sort on the following integer array:
		//     1,0,5,6,3,2,3,7,9,8,4
		int Arr1[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		BubbleSort(Arr1);
		
		// Q2) Write a program to display the first 25 Fibonacci numbers 
		//     beginning at 0
		Fib();
		
		// Q3) Reverse a string without using a temporary variable. Do NOT
		//     use reverse() in the StringBuffer or the StringBuilder APIs.	
		String S = ReverseString("Hello");
		System.out.println("Q3) " + S);
		
		// Q4) Write a program to compute N factorial.
		int actual = factorial(5);
		System.out.println("Q4) " + actual);
		
		// Q5) Write a substring method that accepts a string str and an 
		//     integer idx and returns the substring contained between 0
		//     and  idx-1inclusive.Do  NOT  use  any of the existing substring 
		//     methods in the String, StringBuilder, or StringBuffer APIs.
		String h = "Hello";
		int index = 4;
		char[] X = subString(h, index);
		System.out.print("Q5) ");
		for(int i = 0; i < index; i++) {
			System.out.print(X[i]);
		}
		System.out.print("\n");
		
		// Q6) Write a program to determine if an integer is even without using the
		//     modulus operator (%)
		
		boolean x = even(5);
		System.out.print("Q6) ");
		if(x) System.out.println("The number is even");
		else System.out.println("The number is odd");
		
		//Q8 Write a program that stores the following strings in an ArrayList and 
		//   saves all the palindromes in another ArrayList.
		ArrayList<String> Y = new ArrayList<String>();
		Y.add("karan"); Y.add("madam"); Y.add("tom");
		Y.add("civic"); Y.add("radar"); Y.add("sexes");
		Y.add("jimmy"); Y.add("kayak"); Y.add("john");
		Y.add("refer"); Y.add("billy"); Y.add("did");
		// Print Palindromes
		System.out.println("Q8) Palindromes: ");
		ArrayList<String> P = Palindromes(Y);
		for(int i = 0; i < P.size(); i++) {
			System.out.print(P.get(i) + ", ");
		}
		
		//Q11: Write a program that would access two float-variables from a class
		//     that exists in another package. Note, you will need to create two
		//     packages to demonstrate the solution.
		
		// Create object of the class
		CoreJava2 F = new CoreJava2();
		System.out.println("\nQ11) The two float variables from another class are: " 
							+ F.f1 + ", " + F.f2);
		
		//Q12: Write a program to store numbers from 1 to 100 in an array. 
		//     Print out all the even numbers from the array. 
		//     Use the enhanced FORloop for printing out the numbers.
		
		int arr[] = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println("Q12) Even number in array:");
		for(int a:arr) {
			if(a % 2 == 0)
				System.out.print(a + ", ");
		}
		
		//Q13) Display the triangle on the console as follows using any type of loop. 
		//     Do NOT use a simple group of print statements to accomplish this.
		System.out.println("\n" + "Q13)");
		boolean b = true;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j <= i; j++) {
				if(b) {
					System.out.print("0");
					b = !b;
				}
				else {
					System.out.print("1");
					b = !b;
				}
			}
			System.out.println();
		}
		
		// Q14)  Write a program that demonstrates the switch  case. Implement the following 
		//      functionalities in the cases:
		//      Case1: Find the square root of a number using the Math class method. 
		//      Case2: Display today’s date.
		//      Case3: Split the following string and store it in a sting array.
		//      “I am learning Core Java"
		
		double root = 10;
		int Case = 3;
		Switch(root, Case);
		
		// Q15 Write a program that defines an interface having the following methods:
		//     addition, subtraction, multiplication, and division. Create a class that
		//     implements this interface and provides appropriate functionality to carry
		//	   out the required operations. Hard code two operands in a test class having
		//	   a main method that calls the implementing class
		
		// Implemented in other java files in the same package 
		// (Operations) & (OperationsInterface)
		
		
		
		// Q20 Implemented in package day4Java
	}

	// Q1
	public static void BubbleSort(int[] Arr) {
		
		int n = Arr.length - 1;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n-i-1; j++) {
				
				if(Arr[j] > Arr[j+1]) {
					// Swap
					int temp = Arr[j];
					Arr[j] = Arr[j+1];
					Arr[j+1] = temp;	
				}	
			}
		// Print Array
		System.out.print("Q1) ");
		for(int k = 0; k < n; k++) {
			System.out.print(Arr[k] + ", ");
		}
	}
	// Q2
	public static void Fib() {

		int fib[] = new int[25];
		fib[0] = 0;
		fib[1] = 1;
		
		System.out.println("\nQ2) Fibonacci Series: ");
		System.out.print(fib[0] + ", " + fib[1] + ", ");
		for(int i = 2; i < 25; i++) {
			fib[i] = fib[i-1] + fib[i-2];
			System.out.print(fib[i] + ", ");
		}
		System.out.print("\n");
	}
	
	
	// Q3
	public static String ReverseString(String S) {
		for(int i = 0; i < S.length(); i++) {
			S = S.substring(1, S.length() - i) 
			  + S.substring(0,1) 
			  + S.substring(S.length() - i, S.length());	
		}
		return S;
	}
	
	// Q4
	public static int factorial(int n) {
		if(n > 1) {
			return (n * factorial(n - 1));
		}
		return 1;	
	}	
	
	
	// Q5
	public static char[] subString(String s, int index) {
		char C[] = new char [index];
		for(int i = 0; i < index; i++) {
			char c = s.charAt(i);
			C[i] = c;
		}
		return C;
	}
	// Q6
	public static boolean even(int num) {
		boolean bool;
		
		if((num/2)*2 == num) {
			bool = true;
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	// Q8
	public static ArrayList<String> Palindromes(ArrayList<String> y) {
		
		ArrayList<String> Palindromes = new ArrayList<String>();
		for(int i = 0; i < y.size(); i++) {
			
			String ogWord = y.get(i);
			StringBuilder word = new StringBuilder(ogWord);
			StringBuilder reverse = word.reverse();
			
			if(ogWord.equals(reverse.toString())) {
				String S = ogWord.toString();
				Palindromes.add(S);
			}
		}
		return Palindromes;
	}	
	
	// Q14
	
	public static void Switch(double x, int Case) {
	
		// String
		String str1 = "I am Learning Core Java";
		StringTokenizer Tokenizer = new StringTokenizer(str1," ");	
		String[] S = new String[100];	
		int i = 0;
		System.out.println("Q14) ");
		switch(Case) {
			case 1:
				x = Math.sqrt(x);
				System.out.println(x);
				break;
			case 2:
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				break;
			case 3:
				while(Tokenizer.hasMoreTokens()) {
					S[i] = Tokenizer.nextToken().toString();
					System.out.println(S[i]);
					i++;
				}
				break;
			default:
				System.out.println("Enter correct case number");
			}
	}
}



