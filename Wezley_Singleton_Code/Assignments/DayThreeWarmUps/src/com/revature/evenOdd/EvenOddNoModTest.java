package com.revature.evenOdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvenOddNoModTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void testGetUserInput() {
		
		int expected = 4568973;
		int actual = EvenOddNoMod.getUserInput();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testDetermineEvenOdd() {
		
		String expected = "even";
		String actual = EvenOddNoMod.determineEvenOdd(4);
		assertEquals(expected, actual);
		
	}

}
