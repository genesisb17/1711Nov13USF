package com.rev.d4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WarmupTest {
	
	static Warmup w;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		w = new Warmup();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEven() {
		assertEquals(false, w.isEven(5));
		assertEquals(true, w.isEven(100));
	}

}
