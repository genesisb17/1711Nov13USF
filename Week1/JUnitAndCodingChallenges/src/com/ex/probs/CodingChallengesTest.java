package com.ex.probs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodingChallengesTest {
	CodingChallenges c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		c = new CodingChallenges();
		System.out.println("Before Method");
		
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		System.out.println("After Method");
	}
	
	public void testReverseIt() {
		System.out.println("In Test Reverse Method");
		String expected = "yenom";
		String actual = c.reverseIt("money");
		assertEquals(expected, actual);
	}

	@Test
	public void testFactorial() {
		System.out.println("In Test Factorial method");
		int expected = 120; 
		int actual = c.factorial(5);
		assertEquals(expected,actual);
		
	}
	@Test
	public void testFactorialZero() {
		System.out.println("In test not zero method");
		assertNotEquals(1,c.factorial(5));
		System.out.println("Will Fail");
		assertNotEquals(0, c.factorial(5));
		System.out.println("has failed");
	}

}
