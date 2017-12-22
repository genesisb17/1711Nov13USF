package com.in28minutes.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	
	
	//constructor injection
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}

	//setter injection
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}



	public int binarySearch(int[] numbers, int numberToSearchFor) {
		
		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers=this.sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		//bubble sort algorithm
		//Quick Sort Algorithm
		
		//search the array
		
		//return the result
		return 3;
	}
	
}
