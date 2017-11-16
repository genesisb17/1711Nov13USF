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
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
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
	public void testReverse() {
		String test = "can you reverse this?";
		String expected = "?siht esrever uoy nac";
		assertEquals(expected, CodingChallenges.reverseString(test));
	}

	@Test
	public void testFactorial() {
		int expected = 120;
		try {
			assertEquals(expected, c.factorial(5));
		} catch (Exception e) {
			fail("threw on valid input");
		}
	}
	
	@Test
	public void testFactorialZero() {
		try {
			assertNotEquals(0, c.factorial(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
