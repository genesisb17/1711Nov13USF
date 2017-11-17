package com.ex.probs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DayFourWarmUpTest {
	DayFourWarmUp f;
	
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
		f = new DayFourWarmUp();
		System.out.println("After Method");
	}

	@After
	public void tearDown() throws Exception {
		f = null;
		System.out.println("After Method");
	}

	@Test
	public void testEvenChecker() {
		System.out.println("In Even Checker Method");
		boolean result = true;
		boolean actual = f.evenChecker(4);
		assertEquals(result, actual);
	}

}
