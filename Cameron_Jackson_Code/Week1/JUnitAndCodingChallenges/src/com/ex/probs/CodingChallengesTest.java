package com.ex.probs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
	public void testFactorial() {
		System.out.println("in test factorial method");
		int expected = 40320;
		int actual = c.factorial(8);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFactorialZero() {
		System.out.println("in test not zero method");
		int actual = c.factorial(8);
		assertNotEquals(0, actual);
		assertNotEquals(1, actual);
		System.out.println("has failed");
	}
	
	@Test
	public void testReverseString() {
		System.out.println("in test reverse string method");
		String actual = c.reverseString("hello");
		String expected = "olleh";
		assertEquals(expected, actual);
	}

}
