package com.ex.probs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodingChallengesTest {

	CodingChallenges c ;
	
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
		System.out.println("after method");
	}

	@Test
	public void testFactorial() {
		int expected = 120,
		actual = c.factorial(5);
		assertEquals(expected, actual);
	}

	@Test
	public void testFactorialZero() {
		int expected = 1,
		actual = c.factorial(0);
		assertEquals(expected, actual);
	}

	@Test
	public void testreverseString() {
		String input = "railroad";
		String output = "daorliar";
		assertEquals(output, c.reverseString(input));
	}
	
	@Test
	public void testIsEven() {
		assertEquals(true, c.isEven(2));
		assertEquals (false, c.isEven(3));
	}
}