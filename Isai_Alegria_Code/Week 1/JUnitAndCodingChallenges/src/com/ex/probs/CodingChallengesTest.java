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
		
		System.out.println("Before method");
		c = new CodingChallenges();
		
	}

	@After
	public void tearDown() throws Exception {
		
		System.out.println("After method");
		c = null;
		
	}

	@Test
	public void testFactorial() {
		
		int expected = 120;
		int actual = c.factorial(5);
		
		
		System.out.println("In test factorial method");
		assertEquals(expected,actual);
		//assertNotEquals(0,actual);
		
	}
	
	@Test
	public void testFactorialZero() {
		
		System.out.println("In test factorial not zero");
		assertNotEquals(0,c.factorial(5));
		System.out.println("will fail");
		assertNotEquals(1,c.factorial(5));
		
	}

}
