package com.codingchallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodingChallengesTest {
	
	CodingChallenges c;

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
		c = new CodingChallenges();
		System.out.println("before method");
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		System.out.println("after method");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testNFactorial() {
		System.out.println("in test n factorial");
		int expected = 120;
		int actual = c.fact(5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNFactorialZero() {
		System.out.println("in test not zero factorial");
		assertNotEquals(1, c.fact(5));
		System.out.println(c.fact(5));
		
	}
	
	@Test
	public void testReverseString() {
		System.out.println("in test reverse string");
		String expected = "ABC";
		String actual = c.reverseString("CBA");
		assertEquals(expected, actual);
		System.out.println("Expected: " + expected + "\nActual: " + actual);
	}

}
