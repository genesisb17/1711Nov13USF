package com.revature.Andy;

import java.io.IOException;

public class UnderstandinExceptions {
	
	public static void main(String[] args) {
		int[] arr = new int[4];
		arr[0] = 1;

		try {
			arr[1] = 2;
			arr[6] = 7;
		}catch (ArithmeticException ae) {
			arr[arr.length - 1] = 6;
			ae.printStackTrace();
		}
		finally {
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			System.out.println("passed");
		}
		/*catch(ArrayIndexOutOfBoundsException e) {
			arr[arr.length - 1] = 6;
			e.printStackTrace();
		}*/
		/*
		 * catch (RuntimeException re) {
			re.printStackTrace();
		}
		*/
		
		/*
		static void exampleException(int num) throws IOException{
			System.out.println("we are in example exception method");
			
		}
		*/
	}

}
