package com.revature.Andy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnderstandSearchAndSortsTest {

	UnderstandSearchAndSorts uss = new UnderstandSearchAndSorts();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBubbleSort() {
		int[] expecteds = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		//uss.setArr(arr);
		//uss.bubbleSort();
		//int[] actuals = ;
		assertArrayEquals(expecteds, uss.bubbleSort(arr));		
	}
	
	@Test
	public void testInsertionSort() {
		int[] expecteds = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		assertArrayEquals(expecteds, uss.insertionSort(arr));
	}

}
