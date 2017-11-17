package com.revature.day4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvenTest {
	
	EvenNumber en;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		en = new EvenNumber();
	}

	@After
	public void tearDown() throws Exception {
		en = null;
	}

	@Test
	public void test() {
		String expected = "2 is an even number";
		String actual = en.evenNumber(2);
		assertEquals(expected, actual);
	}

}
