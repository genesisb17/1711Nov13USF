package com.revature.assignments;

import java.util.Comparator;

public class Assignments {

	public static void main(String[] args) {
		printFibonacci();
		System.out.println();
		System.out.println("shorten at 5 is " + mySubString("shorten", 5));
		
		Employees chaz = new Employees("Chaz", "Wait Staff", 23);
		Employees amanda = new Employees("Samantha", "Customer Service", 16);
		
		SortByName sbn = new SortByName();
		SortByDepartment sbd = new SortByDepartment();
		SortByAge sba = new SortByAge();
		//int v1 = s;
		//(x < y) ? x : y;
		if (sbn.compare(chaz, amanda) > 0) {
			System.out.println(chaz);
		}
		else
		{
			System.out.println(amanda);
		}
		if (sbd.compare(chaz, amanda) > 0) {
			System.out.println(chaz);
		}
		else
		{
			System.out.println(amanda);
		}
		if (sba.compare(chaz, amanda) > 0) {
			System.out.println(chaz);
		}
		else
		{
			System.out.println(amanda);
		}

	}

	// 1
	public int[] bubbleSort(int[] a) {
		int[] result = a;
		int n = result.length;
		boolean noSwap = true;
		while (noSwap) {
			noSwap = false;
			for (int i = 0; i < n - 1; i++) {
				if (result[i] > result[i + 1]) {
					int temp = result[i];
					result[i] = result[i + 1];
					result[i + 1] = temp;
					noSwap = true;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");

		}
		System.out.println();
		return result;
	}

	// 2 Fibonacci
	public static void printFibonacci() {
		int n1 = 1;
		int n2 = 0;
		for (int i = 0; i < 25; i++) {
			int temp = n1 + n2;
			System.out.print(temp + ", ");
			n2 = n1;
			n1 = temp;
		}
	}

	// 3. Reverse Strings
	public String reverseString(String string) {

		char[] result = string.toCharArray();
		int al = string.length();
		for (int i = 0; i < al / 2; i++) {
			char temp = result[i];
			result[i] = result[al - i - 1];
			result[al - i - 1] = temp;

			// char temp = string.charAt(i);
			// string.
			// System.out.println(result[al -]);
		}

		System.out.println(new String(result));
		return new String(result);

	}
	
	//4. N Factorial 
	public static int factorial(int n) {
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	//5. Substring
	public static String mySubString(String str, int idx) {
		char[] a = str.toCharArray();
		char[] result = new char[idx];
		int ssl = str.length();
		for (int i = 0; i < idx; i++) {
			result[i] = a[i];
		}

		System.out.println(new String(result));
		return new String(result);
	}
	
	//6. Is Odd 
	public static boolean isOdd(int i) {

		int j = i/2;
		return i != (j*2);

	}
	
	//7. 
	static class SortByName implements Comparator<Employees>{
		@Override
		public int compare(Employees o1, Employees o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	static class SortByDepartment implements Comparator<Employees>{
		@Override
		public int compare(Employees o1, Employees o2) {
			return o1.getDepartment().compareTo(o2.getDepartment());
		}		
	}
	
	static class SortByAge implements Comparator<Employees>{

		@Override
		public int compare(Employees o1, Employees o2) {
			return o1.getAge() - o2.getAge();
		}
		
	}
	
	//8. 
	
	//10. Ternary
	public static int ternaryMin(int x, int y) {
		return (x < y) ? x : y;
	}

	

}
