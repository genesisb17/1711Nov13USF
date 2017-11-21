package InterfaceCreation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArithmeticInterTest {
	/*This JUnit test will be used to test the validity of the methods
	 * that were implemented in the InterfaceImplementer Class
	 * 
	 */
	InterfaceImplementer tester;
	
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
		tester = new InterfaceImplementer();
		System.out.println("After Method");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("After Method");
	}

	@Test
	public void testAddition() {
		System.out.println("In Addition Method");
		int result =31;
		int actual = tester.addition(15, 16);
		assertEquals(result, actual);
		
	}

	@Test
	public void testSubtraction() {
		System.out.println("In Subtraction Method");
		int result = 31;
		int actual = tester.subtraction(62, 31);
		assertEquals(result, actual);
	}

	@Test
	public void testMultiplication() {
		System.out.println("In Multiplicatoin Method");
		int result = 30;
		int actual = tester.multiplication(5, 6);
		assertEquals(result, actual);
	}

	@Test
	public void testDivision() {
		System.out.println("In Division Method");
		double result = 3;
		double actual = tester.division(30, 10);
		assertEquals(result, actual, 10000);
	}

}
