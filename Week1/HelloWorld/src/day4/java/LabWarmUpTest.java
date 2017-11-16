package day4.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabWarmUpTest {

	LabWarmUp c;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		c = new LabWarmUp();
	}

	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test
	void testEvenStuff() {
		boolean actual = c.EvenStuff(6);
		assertTrue(actual);
	}

	@Test
	void testminimumOf() {
		
		int actual = c.minimumOf(6, 8);
		int expected = 6;
		assertEquals(expected, actual);
	}
}
