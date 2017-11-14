package day2demo;

import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		
		int [] arr = new int [4];
		arr[0] = 1;
		
		try {
			arr[6] = 6;
		}
		/*
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} 
		catch(RuntimeException re) {
			re.printStackTrace();
		}
		*/
		catch(ArithmeticException e) {
			arr[arr.length - 1] = 2;
			e.printStackTrace();
		}
	
		finally {
			System.out.println("passed exception");
		}

	}
	
	static void exampleException(int num) throws IOException {
		
		System.out.println("We are in example exception method");
		throw new IOException();
	
	}

}
