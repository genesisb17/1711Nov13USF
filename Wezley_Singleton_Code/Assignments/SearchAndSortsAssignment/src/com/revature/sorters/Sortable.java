package com.revature.sorters;

/*
 *  A functional interface so that each sorter class can use lambdas to override the sorter() method, while still inheriting 
 *  from the main Sorter class. 
 */
public interface Sortable {
	
	public int[] sorter(int[] intArr);
	
}
