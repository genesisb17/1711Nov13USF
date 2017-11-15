package com.revature.hello;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[4];
		
		try {
			arr[0] = 1;
			arr[6] = 6;
		}catch(RuntimeException re) {
			re.printStackTrace();
		}/*catch(ArrayIndexOutOfBoundsException x) {
			x.printStackTrace();
		}*/
		System.out.println("passed exception");
		
		
	}
	
	
	/*
	 * Implement the following:
	 * binary search
	 * breadth first search
	 * depth first search
	 * bubble sort
	 * merge sort
	 * insertion sort
	 * 
	 * 
	 */
	

}
