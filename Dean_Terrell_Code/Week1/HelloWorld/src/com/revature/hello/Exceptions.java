package com.revature.hello;

public class Exceptions {

	public static void main(String[] args) {
		
		int[] arr = new int[4];
		arr[0] = 1;
		try {
			arr[6] = 6;
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		System.out.println("passed exception");
	}

}