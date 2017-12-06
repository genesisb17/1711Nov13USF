package com.revature.andrew;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodingChallengeTest {

	CodingChallenge c;
	
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

		c = new CodingChallenge();
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");

		c = null;
		
	}

	@Test
	public void testFactorial() {
		System.out.println("in test factorial");
		
		int expected = 120;
		int actual = c.factorial(5);
		assertEquals(expected, actual);

	}
	
	@Test
	public void testFactorialZero() {
		System.out.println("in test not zero");
		assertNotEquals(0, c.factorial(5));
	}
	
	@Test
	public void testReverse() {
		System.out.println("in test reverse");
		assertEquals( "god", c.reverseString("dog"));
		assertEquals("doof", c.reverseString("food"));
		assertEquals("ecarg", c.reverseString("grace"));
	}
	@Test
	public void testNotReverse() {
		System.out.println("in test reverse");
		assertNotEquals(c.reverseString("dog"), "dog");
		assertNotEquals(c.reverseString("food"), "food");
		assertNotEquals(c.reverseString("grace"), "grace");
	}

}
