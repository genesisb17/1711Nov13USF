package com.revature.warmup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Warmup1116Test {
	Warmup1116 wu = new Warmup1116();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testIsOdd() {

		System.out.println("in test is odd");
		assertTrue(wu.isOdd(3));

	}
	
	@Test
	public void testIsNotOdd() {

		System.out.println("in test is not odd");
		assertFalse(wu.isOdd(4));

	}
	
	@Test
	public void testTernaryMin() {
		assertEquals(1, wu.ternaryMin(1, 2));
		assertEquals(2, wu.ternaryMin(2, 4));
		assertEquals(12, wu.ternaryMin(12, 22));
		assertEquals(31, wu.ternaryMin(31, 32));
		assertEquals(100, wu.ternaryMin(100, 200));
	}
	
	@Test
	public void testNotTernaryMin() {
		assertNotEquals(2, wu.ternaryMin(1, 2));
		assertNotEquals(4, wu.ternaryMin(2, 4));
		assertNotEquals(2, wu.ternaryMin(12, 22));
		assertNotEquals(1, wu.ternaryMin(31, 32));
		assertNotEquals(200, wu.ternaryMin(100, 200));
	}
	/*
	@Test
	public void testPrimeList() {
		
		System.out.println("in test prime list");
		ArrayList<Integer> pl = wu.primeList();
		assertTrue(pl.contains(3));
		assertTrue(pl.contains(5));
		assertTrue(pl.contains(7));
		assertTrue(pl.contains(11));
		assertTrue(pl.contains(13));
		
	}
	

	@Test
	public void testNotPrimeList() {
		
		System.out.println("in test not prime list");
		ArrayList<Integer> pl = wu.primeList();
		assertTrue(pl.contains(4));
		assertTrue(pl.contains(6));
		assertTrue(pl.contains(8));
		assertTrue(pl.contains(12));
		assertTrue(pl.contains(14));
		
	}
	*/

}
