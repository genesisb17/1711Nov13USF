package com.revature.day4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day4ChallengesTest {

	Day4Challenges func;
	
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
	public void testOddNum() {
		int num = 5;
		assertFalse(func.IsEven(num));
	}

	@Test
	public void testEvenNum() {
		int num = 4;
		assertTrue(func.IsEven(num));
	}
	
	@Test 
	public void testMinimum() {
		int expected = 7;
		int actual = func.Minimum(10, 7);
		assertEquals(expected, actual);
	}
}
