package com.warmup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WarmUpsTest {
	
	WarmUps w;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		w = new WarmUps();
	}

	@After
	public void tearDown() throws Exception {
		w = null;
	}

	@Test
	public void testDetermineInt() {
		int x = 6;
		String actual = w.determineInt(x);
		assertEquals(w.determineInt(x), "Even");
		x = 7;
		assertEquals(w.determineInt(x), "Odd");
	}
	
}
