package com.revature.hello;

import java.io.IOException;

public class UnderstandingExceptions {
	public static void main(String[] args) {
		int[] arr = new int[4];

		try {
		arr[0] = 1;
		arr[7] = 6;
		}
		
		catch(ArithmeticException e) {
			arr[arr.length-1] = 2;
			e.printStackTrace();
		}
		finally {
		System.out.println(arr[0]);
		System.out.println("passed");
		}
		try {
			ExceptionExample(6);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void ExceptionExample(int x) throws IOException{
		System.out.println("we are in example exception method");
		throw new IOException();
	}
}
