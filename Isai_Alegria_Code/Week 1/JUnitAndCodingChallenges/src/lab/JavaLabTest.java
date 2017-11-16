package lab;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JavaLabTest {

	JavaLab j;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		j = new JavaLab();
	}

	@After
	public void tearDown() throws Exception {
		
		j = null;
	}

	@Test
	public void testEvenOrOdd() {
		
		boolean check = true;
		boolean actual = j.evenOrOdd(10);
		assertEquals(check,actual);
		
	}

	

}
