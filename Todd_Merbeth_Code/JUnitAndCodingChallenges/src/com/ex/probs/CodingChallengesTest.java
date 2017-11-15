package com.ex.probs;

import static org.junit.Assert.*; // imports static methods from class, 
								  // if just import without static you wont get the static classes

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodingChallengesTest {
	
	CodingChallenges c; // declaring

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
		c = new CodingChallenges(); // instanciating
		System.out.println("before method");
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		System.out.println("after method");
	}

	@Test
	public void testFactorial() {
		System.out.println("In testFactorial method");
		int expected = 120;
		int actual = c.factorial(5);
		assertEquals(expected, actual);	
	}
	@Test
	public void testFactorialZero() {
		System.out.println("In testFactorialZero method");
		assertNotEquals(0, c.factorial(5));
		assertNotEquals(1, c.factorial(5));
	}
	@Test
	public void testStringReversal() {
		System.out.println("In stringReversal method");
		assertEquals("gnirts", c.reverseString("string"));
		assertNotEquals("string", c.reverseString("string"));
	}

}
