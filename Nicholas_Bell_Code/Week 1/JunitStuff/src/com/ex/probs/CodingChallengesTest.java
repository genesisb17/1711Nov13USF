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
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("afterclass");
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
		int expected = 120;
		int actual = c.factorial(5);
		assertEquals(expected, actual);
		assertNotEquals(0, actual);
	}
	
	@Test
	public void testFactorialZero() {
		assertNotEquals(1, c.factorial(5));

	}

	@Test
	public void testReverseString() {
		assertEquals("nmad", c.reverseString("damn"));
	}
}
