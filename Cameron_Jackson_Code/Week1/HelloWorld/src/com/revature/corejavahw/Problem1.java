package com.revature.corejavahw;

import com.revature.day2.SearchAndSorts;

public class Problem1 {

	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		SearchAndSorts.BubbleSort(arr);
		for (int i : arr) 
			System.out.print(i + " ");
		
		System.out.println("");
	}

}
