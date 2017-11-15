package com.revature.day2;

public class MyExceptions {

	public static void main(String[] args) {
		int[] arr = new int[4];
		arr[0] = 1;
		try {
			arr[7] = 6;
		}
		catch (ArithmeticException e) {
			arr[arr.length-1] = 2;
			e.printStackTrace();
		}
		finally {
			System.out.println("\n" + arr[3]);
			System.out.println("passed exception");
		}
		
	}

}
