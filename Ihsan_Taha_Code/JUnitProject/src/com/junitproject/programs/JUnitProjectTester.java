package com.junitproject.programs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitProjectTester {
	
	JUnitProject j;

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
		j = new JUnitProject();
		System.out.println("before method");
	}

	@After
	public void tearDown() throws Exception {
		j = null;
		System.out.println("after method");
	}
	
	@Test
	public void testModuloEven() {
		System.out.println("in even test modulo");
		String expected = "even";
		String actual = j.modulo(10);
		assertEquals(expected, actual);
		System.out.println("Expected: " + expected + "\nActual: " + actual);
	}
	
	@Test
	public void testPrintPrimeNumbers() {
		System.out.println("in testPrintPrimeNumbers");
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < arrayList.size()-1; i++) {
			arrayList.add(i);
		}
		
		for (int i = 0; i < arrayList.size()-1; i++) {
			System.out.println(arrayList.get(i));
		}
	}
	
	@Test
	public void testMinimum() {
		System.out.println("in minimum of two numbers test modulo");
		int expected = 5;
		int actual = j.minimum(10, 5);
		assertEquals(expected, actual);
		System.out.println("Expected: " + expected + "\nActual: " + actual);
	}

}
