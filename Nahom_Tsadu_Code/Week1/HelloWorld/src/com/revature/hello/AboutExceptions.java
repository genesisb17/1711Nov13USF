package com.revature.hello;

public class AboutExceptions {
	
	public static void main(String[] args) {
		
		int[] arr = new int[4];
		arr[0] = 1;
		
		try{
			
			arr[6] = 6;
		}catch(ArrayIndexOutOfBoundsException e){
			
			arr[arr.length - 1] = 6;
			e.printStackTrace();
		}
		
		
		System.out.println("Passed Exception!");
	}

}
