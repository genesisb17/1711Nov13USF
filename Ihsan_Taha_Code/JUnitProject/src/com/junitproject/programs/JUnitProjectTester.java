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

		// Create and populate an array list from 1 to 100
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			arrayList.add(i + 1);
		}

		// test each index for whether the number within is prime
		boolean expected = false, actual = false;
		for (int n = arrayList.size()-1; n >= 0; n--) {
			switch (arrayList.get(n)) {
			case 2:
			case 3:
			case 5:
			case 7:
			case 11:
			case 13:
			case 17:
			case 19:
			case 23:
			case 29:
			case 31:
			case 37:
			case 41:
			case 43:
			case 47:
			case 53:
			case 59:
			case 61:
			case 67:
			case 71:
			case 73:
			case 79:
			case 83:
			case 89:
			case 97:
				expected = true;
				actual = true;
				break;
			default:
				expected = false;
				actual = false;
				break;
			}
			
			actual = j.printPrimeNumbers(arrayList.get(n));
			assertEquals(expected, actual);
			System.out.println("Value: " + arrayList.get(n) + "\nExpected: " + expected + "\nActual: " + actual);

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
